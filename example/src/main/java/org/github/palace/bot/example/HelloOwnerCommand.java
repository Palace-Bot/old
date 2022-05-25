package org.github.palace.bot.example;

import net.mamoe.mirai.contact.MemberPermission;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.plugin.AbstractCommand;

/**
 * @author jihongyuan
 * @date 2022/5/25 11:11
 */
public class HelloOwnerCommand extends AbstractCommand {

    public HelloOwnerCommand() {
        super("你好", MemberPermission.ADMINISTRATOR, false, "你好, 群主！我是PalaceBot！");
    }

    @CommandHandler
    public void handler(CommandSender commandSender) {
        commandSender.sendMessage(" 你好, 群主！我是PalaceBot！");
    }

}
