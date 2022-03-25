package org.github.palace.bot.core.handler;

import org.github.palace.bot.core.EventHandler;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import org.github.palace.bot.core.cli.CommandLine;
import org.github.palace.bot.core.collection.GroupContextMap;
import org.github.palace.bot.core.utils.MiraiCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * @author JHY
 * @date 2022/3/22 15:36
 */
public class GroupEventHandler implements EventHandler<GroupMessageEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupEventHandler.class);

    // 我也不懂是不是线程安全
    /**
     * 保留用户命令上下文
     * key: 群号, value: {key: qq, value: 最近聊天记录}
     */
    private final GroupContextMap groupContextMap = new GroupContextMap();

    @Override
    public void onEvent(GroupMessageEvent event) {
        Group subject = event.getSubject();
        MessageChain chain = event.getMessage();

        MessageSource messageSource = (MessageSource) chain.get(0);

        String miraiCode = chain.serializeToMiraiCode();
        LOGGER.info("[miraiCode]: {}", miraiCode);
        LOGGER.error("[miraiCode]: {}", miraiCode);
        // 回复用户
        NormalMember normalMember = Optional
                .ofNullable(subject.get(messageSource.getFromId()))
                .orElseThrow(RuntimeException::new);

        // at机器人
        if (MiraiCodeUtil.isAtMe(miraiCode)) {
            CommandLine commandLine = new CommandLine(chain.get(2).contentToString().trim(), CommandLine.State.NEW);
            // TODO 处理命令前
            groupContextMap.put(subject.getId(), messageSource.getFromId(), commandLine);
            subject.sendMessage(new At(normalMember.getId()).plus(" ").plus("请输入y/n:"));
            // TODO 处理命令后
            commandLine.setState(CommandLine.State.PREPARE);
        }

        CommandLine commandLine = null;
        try {
            commandLine = groupContextMap.get(subject.getId(), messageSource.getFromId(), CommandLine.State.PREPARE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO
        if (commandLine != null) {
            if (chain.get(1).contentToString().trim().equals("y")) {
                subject.sendMessage(new At(normalMember.getId()).plus(" ").plus(commandLine.getName()).plus(" 命令正在处理中..."));
                subject.sendMessage(new At(normalMember.getId()).plus(" ").plus(commandLine.getName()).plus(" 已结束..."));
                commandLine.setState(CommandLine.State.FINISH);
            } else if (chain.get(1).contentToString().trim().equals("n")) {
                subject.sendMessage(new At(normalMember.getId()).plus(" ").plus(commandLine.getName()).plus(" 命令已拒绝"));
                commandLine.setState(CommandLine.State.FINISH);
            }
        }
    }

    @Override
    public Class<GroupMessageEvent> getHandlerEvent() {
        return GroupMessageEvent.class;
    }

}
