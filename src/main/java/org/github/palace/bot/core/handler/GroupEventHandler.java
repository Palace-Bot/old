package org.github.palace.bot.core.handler;

import org.github.palace.bot.core.EventHandler;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author JHY
 * @date 2022/3/22 15:36
 */
public class GroupEventHandler implements EventHandler<GroupMessageEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupEventHandler.class);

    @Override
    public void onEvent(GroupMessageEvent event) {
        Group subject = event.getSubject();
        MessageChain chain = event.getMessage();

        MessageSource messageSource = (MessageSource) chain.get(0);
        List<At> atList = new ArrayList<>();
        List<PlainText> plainTextList = new ArrayList<>();
        List<Face> faceList = new ArrayList<>();
        List<Image> imageList = new ArrayList<>();

        for (int i = 1; i < chain.size(); i++) {
            SingleMessage message = chain.get(i);

            if (message instanceof At) {
                atList.add((At) message);
            }
            if (message instanceof PlainText) {
                plainTextList.add((PlainText) message);
            }
            if (message instanceof Face) {
                faceList.add((Face) message);
            }
            if (message instanceof Image) {
                imageList.add((Image) message);
            }
        }

        boolean atMe = false;
        for (At at : atList) {
            if (at.contentToString().equals("@1515023757")) {
                atMe = true;
                break;
            }
        }

        // TODO at bot
        if (atMe) {
            // 回复用户
            NormalMember normalMember = Optional
                    .ofNullable(subject.get(messageSource.getFromId()))
                    // TODO
                    .orElseThrow(RuntimeException::new);

            // 匹配命令
        } else {
            // TODO 普通消息，插入数据库
        }

    }

    @Override
    public Class<GroupMessageEvent> getHandlerEvent() {
        return GroupMessageEvent.class;
    }

}
