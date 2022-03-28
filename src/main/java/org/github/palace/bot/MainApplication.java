package org.github.palace.bot;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import org.github.palace.bot.builder.BotConfigurationBuilder;
import org.github.palace.bot.core.EventDispatcher;

import static org.github.palace.bot.constant.BaseConstant.PASSWORD;
import static org.github.palace.bot.constant.BaseConstant.QQ;

/**
 * @author JHY
 * @date 2022/3/22 10:38
 */
public class MainApplication {
    public static void main(String[] args) {
        Bot bot = BotFactory.INSTANCE.newBot(QQ, PASSWORD, BotConfigurationBuilder.builder());
        bot.login();

        EventDispatcher eventDispatcher = new EventDispatcher();
        eventDispatcher.start();
    }

}
