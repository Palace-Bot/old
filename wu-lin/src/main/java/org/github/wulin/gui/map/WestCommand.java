package org.github.wulin.gui.map;

import net.mamoe.mirai.message.data.PlainText;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.cli.SimpleCommand;

/**
 * 西指令
 *
 * @author jihongyuan
 * @date 2022/4/12 15:36
 */
public class WestCommand extends SimpleCommand {

    public WestCommand() {
        super("a", null, false, "");
    }

    @CommandHandler
    public void handler(CommandSender commandSender, PlainText plainText, CommandSession session) {
        session.finish();
    }

}