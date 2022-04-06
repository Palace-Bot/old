package org.github.palace.bot.core.cli.support;

import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.MessageSource;
import net.mamoe.mirai.message.data.SingleMessage;
import org.github.palace.bot.core.cli.Command;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.collection.GroupContextMap;

/**
 * 管理命令执行状态
 *
 * @author JHY
 * @date 2022/3/28 9:02
 */
public class CommandSessionHelper {

    // 我也不懂是不是线程安全
    /**
     * 保留用户命令上下文
     * key: 群号, value: {key: qq, value: 最近聊天记录}
     */
    private final GroupContextMap groupContextMap = new GroupContextMap();

    public CommandSession put(MessageSource messageSource, Command command) {
        CommandSession commandSession = new CommandSession(command).runnable();
        groupContextMap.put(messageSource.getTargetId(), messageSource.getFromId(), commandSession);
        return commandSession;
    }

    public CommandSession get(MessageSource messageSource, CommandSession.State state) {
        return groupContextMap.get(messageSource.getTargetId(), messageSource.getFromId(), state);
    }

    public CommandSession prepare(CommandSession commandSession) {
        return commandSession.prepare();
    }

    public CommandSession crash(CommandSession commandSession) {
        return commandSession.crash();
    }

    public CommandSession finish(CommandSession commandSession) {
        return commandSession.finish();
    }

    public void sendDetermine(Group subject, MessageSource messageSource, SingleMessage singleMessage) {
        String determine = singleMessage.contentToString().trim().toLowerCase();

        At at = new At(messageSource.getFromId());
        CommandSession commandSession = this.get(messageSource, CommandSession.State.PREPARE);

        if ("y".equals(determine) || "yes".equals(determine)) {
            subject.sendMessage(at.plus(" ").plus(commandSession.getCommand().getPrimaryName()).plus(" 命令正在处理中..."));
            subject.sendMessage(at.plus(" ").plus(commandSession.getCommand().getPrimaryName()).plus(" 已结束..."));
        } else if ("n".equals(determine) || "no".equals(determine)) {
            subject.sendMessage(at.plus(" ").plus(commandSession.getCommand().getPrimaryName()).plus(" 命令已拒绝"));
        }
    }
}