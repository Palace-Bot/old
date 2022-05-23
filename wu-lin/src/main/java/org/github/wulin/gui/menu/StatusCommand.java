package org.github.wulin.gui.menu;

import net.mamoe.mirai.message.data.PlainText;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.plugin.SimpleCommand;
import org.github.wulin.context.PlayerContext;
import org.github.wulin.core.person.Player;
import org.github.wulin.utils.StringPrintUtil;

/**
 * @author jihongyuan
 * @date 2022/4/12 14:52
 */
public class StatusCommand extends SimpleCommand {

    public StatusCommand() {
        super("状态", null, false, "");
    }

    @CommandHandler
    public void handler(CommandSender commandSender, PlainText plainText, CommandSession session) {
        Player player = PlayerContext.getPlayer(commandSender.getUser().getId());

        StringBuilder sb = StringPrintUtil.print(new Object[][]{
                {"角色名称", player.getName()},
                {"力量", player.getProperty().getStrength()},
                {"敏捷", player.getProperty().getAgility()},
                {"智力", player.getProperty().getIntelligence()},
        });
        commandSender.sendMessage(sb.toString());
    }

}