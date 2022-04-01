package org.github.palace.bot.core.plugin;

import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.SimpleCommand;

/**
 * @author JHY
 * @date 2022/3/30 16:35
 */
public class WordCloudCommand extends SimpleCommand {
    public WordCloudCommand() {
        super(null, null, false, null);

    }

    @CommandHandler
    public void handler(Member member, Group group) {
        System.out.println("11111111111");
    }

}
