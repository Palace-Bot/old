package org.github.palace.bot.plugin;

import org.github.palace.bot.core.cli.Command;
import org.github.palace.bot.core.cli.SimpleCommand;

/**
 * @author JHY
 * @date 2022/3/30 16:35
 */
public class WordCloudCommand extends SimpleCommand {
    public WordCloudCommand() {
        super(Command.builder()
                .primaryName("查看个人词云")
                .determine(false)
                .description("查看最近一周内群组聊天记录生成的词云")
        );
    }

}
