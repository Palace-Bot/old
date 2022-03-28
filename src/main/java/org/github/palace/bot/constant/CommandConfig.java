package org.github.palace.bot.constant;

import org.github.palace.bot.MainApplication;
import org.github.palace.bot.core.io.YamlLoader;

import static org.github.palace.bot.utils.TypeUtil.cast;

/**
 * @author JHY
 * @date 2022/3/27 15:20
 */
public final class CommandConfig {

    public static final String COMMAND_PREFIX;

    static {
        COMMAND_PREFIX = cast(YamlLoader.loadYamlNames("bot.base.command-prefix", MainApplication.class.getClassLoader()), String.class);
    }

    private CommandConfig() {
    }

}
