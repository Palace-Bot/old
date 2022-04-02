package org.github.palace.bot.core.plugin;

import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.MessageSource;
import net.mamoe.mirai.message.data.PlainText;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.SimpleCommand;

/**
 * @author JHY
 * @date 2022/3/30 16:35
 */
public class WordCloudCommand extends SimpleCommand {
    public WordCloudCommand() {
        super("查看个人词云", null, false, null);
    }

    @CommandHandler
    public void handler(CommandSender commandSender, MessageSource messageSource, PlainText plainText) {
        commandSender.sendMessage(new At(messageSource.getFromId()).plus(" ").plus(plainText));
    }

}
