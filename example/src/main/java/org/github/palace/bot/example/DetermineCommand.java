package org.github.palace.bot.example;

import net.mamoe.mirai.contact.MemberPermission;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.plugin.AbstractCommand;

/**
 * @author jihongyuan
 * @date 2022/5/25 11:12
 */
public class DetermineCommand extends AbstractCommand {
    public DetermineCommand() {
        super("确认", MemberPermission.MEMBER, true, "你好, 确认！我是PalaceBot！");
    }

    @CommandHandler
    public void handler(CommandSender commandSender) {
        commandSender.sendMessage(" 确认成功！");
    }

}
