package org.github.palace.bot.core;

import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import org.github.palace.bot.MainApplication;
import org.github.palace.bot.core.io.BotFactoriesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JHY
 * @date 2022/3/22 17:04
 */
public class EventDispatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventDispatcher.class);

    private final List<Listener<?>> listeners = new ArrayList<>();
    private List<EventHandler<Event>> handlers = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EventDispatcher() {
        ClassLoader classLoader = MainApplication.class.getClassLoader();
        List<String> handlers = BotFactoriesLoader.loadFactoryNames(EventDispatcher.class, classLoader);

        for (String handlerClass : handlers) {
            try {
                Class<?> clazz = classLoader.loadClass(handlerClass);
                EventHandler<Event> eventHandler = (EventHandler<Event>) clazz.newInstance();
                this.handlers.add(eventHandler);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        for (EventHandler<Event> handler : handlers) {
            Listener<Event> eventListener = GlobalEventChannel.INSTANCE
                    .subscribeAlways(handler.getHandlerEvent(), handler::onEvent);
            listeners.add(eventListener);
        }

    }
}
