package org.github.palace.bot.core.cli.manager;

import net.mamoe.mirai.message.data.Message;
import net.mamoe.mirai.message.data.MessageSource;
import org.github.palace.bot.MainApplication;
import org.github.palace.bot.constant.CommandConfig;
import org.github.palace.bot.core.cli.Command;
import org.github.palace.bot.core.utils.JSONUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JHY
 * @date 2022/3/27 15:28
 */
public class DefaultCommandManager implements CommandManager {

    private final Map<String, Command> commandMap = new HashMap<>(16);

    public DefaultCommandManager(String name) {
        InputStream is = MainApplication.class.getClassLoader().getResourceAsStream(name);
        Command[] commands = JSONUtil.readValue(is, Command[].class);
        for (Command command : commands) {
            registerCommand(command);
        }
    }

    @Override
    public boolean registerCommand(Command command) {
        // TODO
        commandMap.put(command.getPrimaryName(), command);
        return true;
    }

    @Override
    public void executeCommand(MessageSource messageSource, Message message) {

    }

    @Override
    public void executeCommand(MessageSource messageSource, Command command, Message arguments) {

    }

    @Override
    public Command matchCommand(String commandName) {
        if (commandName.startsWith(CommandConfig.COMMAND_PREFIX) && commandName.length() > 1) {
            return commandMap.get(commandName.substring(commandName.indexOf(CommandConfig.COMMAND_PREFIX) + 1).toLowerCase());
        }
        return null;
    }
}
