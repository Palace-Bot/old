package org.github.wulin.gui.map;

import net.mamoe.mirai.message.data.PlainText;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.cli.SimpleCommand;

/**
 * 北指令
 *
 * @author jihongyuan
 * @date 2022/4/12 15:37
 */
public class NorthCommand extends SimpleCommand {

    public NorthCommand() {
        super("w", null, false, "");
    }

    @CommandHandler
    public void handler(CommandSender commandSender, PlainText plainText, CommandSession session) {
        session.finish();
    }

}