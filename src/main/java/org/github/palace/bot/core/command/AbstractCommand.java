package org.github.palace.bot.core.command;

import net.mamoe.mirai.message.code.MiraiCode;
import net.mamoe.mirai.message.data.*;
import org.github.palace.bot.enums.MessageType;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 解析 {@code miraiCode}, 选择合适的命令处理器执行
 *
 * @author JHY
 * @date 2022/3/23 14:53
 */
public abstract class AbstractCommand implements ICommand {
    private final Map<MessageType, List<SingleMessage>> messageTypeMap = new LinkedHashMap<>();

    @Override
    public void invoke(String miraiCode) {
    }

    public void parse(String miraiCode) {
        parseMiraiCode(miraiCode);

        StringBuilder sb = new StringBuilder();
        for (SingleMessage singleMessage : messageTypeMap.get(MessageType.PLAIN_TEXT)) {
            String plainText = singleMessage.contentToString();
            sb.append(plainText).append(" ");
        }
        String commandLine = sb.toString();
        parseCommandLine(commandLine);
    }

    /**
     * 解析miraiCode
     */
    public void parseMiraiCode(String miraiCode) {
        MessageChain chain = MiraiCode.deserializeMiraiCode(miraiCode);

        messageTypeMap.put(MessageType.MESSAGE_SOURCE, chain.stream().filter(MessageSource.class::isInstance).collect(Collectors.toList()));
        messageTypeMap.put(MessageType.AT, chain.stream().filter(At.class::isInstance).collect(Collectors.toList()));
        messageTypeMap.put(MessageType.PLAIN_TEXT, chain.stream().filter(PlainText.class::isInstance).collect(Collectors.toList()));
        messageTypeMap.put(MessageType.FACE, chain.stream().filter(Face.class::isInstance).collect(Collectors.toList()));
        messageTypeMap.put(MessageType.IMAGES, chain.stream().filter(Image.class::isInstance).collect(Collectors.toList()));
    }

    public void parseCommandLine(String commandLine){

    }

    protected abstract void parseCommand(PlainText plainText);

}
