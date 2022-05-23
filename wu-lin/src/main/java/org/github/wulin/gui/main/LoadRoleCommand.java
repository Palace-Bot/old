package org.github.wulin.gui.main;

import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.plugin.SimpleCommand;

/**
 * @author jihongyuan
 * @date 2022/4/8 21:57
 */
public class LoadRoleCommand extends SimpleCommand {

    public LoadRoleCommand() {
        super("读取角色", null, false, "");
    }

    @CommandHandler
    public void handler(CommandSender commandSender) {
        commandSender.sendMessage("暂不支持");
    }

}
