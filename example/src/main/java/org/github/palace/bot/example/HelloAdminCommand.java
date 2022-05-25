package org.github.palace.bot.example;

import net.mamoe.mirai.contact.MemberPermission;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.plugin.AbstractCommand;

/**
 * @author jihongyuan
 * @date 2022/5/25 11:10
 */
public class HelloAdminCommand extends AbstractCommand {

    public HelloAdminCommand() {
        super("你好", MemberPermission.ADMINISTRATOR, false, "你好, 管理员！我是PalaceBot！");
    }

    @CommandHandler
    public void handler(CommandSender commandSender) {
        commandSender.sendMessage(" 你好, 管理员！我是PalaceBot！");
    }

}
