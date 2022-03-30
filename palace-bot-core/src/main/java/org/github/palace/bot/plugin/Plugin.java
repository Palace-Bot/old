package org.github.palace.bot.plugin;

import lombok.Getter;
import org.github.palace.bot.core.cli.SimpleCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JHY
 * @date 2022/3/30 15:47
 */
public abstract class Plugin implements PluginLoaderLifeCycle {

    /**
     * 命令链
     */
    private final List<SimpleCommand> commandChina = new ArrayList<>();

    @Getter
    private final String version;

    @Getter
    private final String name;

    @Getter
    private final String description;

    protected Plugin(String version, String name, String description) {
        this.version = version;
        this.name = name;
        this.description = description;
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    /**
     * 注册命令
     */
    protected Plugin register(SimpleCommand command) {
        commandChina.add(command);
        return this;
    }

}