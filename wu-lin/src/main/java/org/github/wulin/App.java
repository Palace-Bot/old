package org.github.wulin;

import org.github.palace.bot.core.plugin.Plugin;
import org.github.wulin.gui.MainCommand;
import org.github.wulin.gui.menu.StatusCommand;

/**
 * @author jihongyuan
 * @date 2022/4/8 21:49
 */
public class App extends Plugin {

    public App() {
        super("1.0-SNAPSHOT", "词云", "在QQ群中查看个人词云");
    }

    @Override
    public void onLoad() {
        register(new MainCommand());
    }

}
