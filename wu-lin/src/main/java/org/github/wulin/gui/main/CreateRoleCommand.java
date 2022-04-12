package org.github.wulin.gui.main;

import net.mamoe.mirai.message.data.PlainText;
import org.github.palace.bot.core.annotation.ChildCommandHandler;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.CommandSession;
import org.github.palace.bot.core.cli.SimpleCommand;
import org.github.wulin.context.PlayerContext;
import org.github.wulin.core.person.Player;

import java.util.Random;

/**
 * @author jihongyuan
 * @date 2022/4/8 21:57
 */
public class CreateRoleCommand extends SimpleCommand {

    public CreateRoleCommand() {
        super("创建角色", null, false, "");
    }

    @CommandHandler
    public void handler(CommandSender commandSender) {
        String text = "请输入您的角色名称：";
        commandSender.sendMessage(text);
    }

    @ChildCommandHandler(primaryName = "*")
    public void handler(CommandSender commandSender, PlainText plainText, CommandSession session) {
        String text = "您的角色名称为：" + plainText;
        commandSender.sendMessage(text);
        session.finish();

        Player player = new Player(plainText.contentToString());
        Random random = new Random();
        player.init(random.nextInt(10), random.nextInt(10), random.nextInt(10));
        PlayerContext.putPlayer(commandSender.getUser().getId(), player);
    }

}
