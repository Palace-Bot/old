package org.github.palace.bot.plugin;

/**
 * @author JHY
 * @date 2022/3/30 16:01
 */
public class App extends Plugin {

    {
        super.register(new WordCloudCommand());
    }

    public App() {
        super("1.0-SNAPSHOT", "词云", "在QQ群中查看个人词云");
    }

}