package org.github.wulin.gui.map;

import net.mamoe.mirai.message.data.PlainText;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.cli.SimpleCommand;
import org.github.wulin.context.PlayerContext;
import org.github.wulin.core.person.Player;
import org.github.wulin.utils.StringPrintUtil;

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
        Player player = PlayerContext.getPlayer(commandSender.getUser().getId());
        int[] currentMapIndex = player.getCurrentMapIndex();
        if(currentMapIndex[1] - 1 >= 0){
            currentMapIndex[1] = currentMapIndex[1] - 1;
            player.setCurrentMapIndex(currentMapIndex);
        }
        StringBuilder sb = StringPrintUtil.printfMap(player);
        commandSender.sendMessage(sb.toString());
    }

}