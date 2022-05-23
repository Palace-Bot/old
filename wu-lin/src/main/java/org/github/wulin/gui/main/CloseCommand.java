package org.github.wulin.gui.main;

import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.plugin.SimpleCommand;

/**
 * @author jihongyuan
 * @date 2022/4/8 21:57
 */
public class CloseCommand extends SimpleCommand {

    public CloseCommand() {
        super("关闭游戏", null, false, "");
    }

    @CommandHandler
    public void handler(CommandSender commandSender, CommandSession session) {
        commandSender.sendMessage("游戏已退出...");
        session.finish();
    }

}
