package org.github.palace.bot.example;


import org.github.palace.bot.core.plugin.Plugin;

/**
 * @author jihongyuan
 * @date 2022/5/25 11:01
 */
public class App extends Plugin {

    public App() {
        super("1.0-SNAPSHOT", "例子", "例子");
    }

    @Override
    public void onLoad() {
        super.register(new HelloAdminCommand());
        super.register(new HelloMemberCommand());
        super.register(new HelloOwnerCommand());
        super.register(new DetermineCommand());
    }

}