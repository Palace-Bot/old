package org.github.palace.bot.core.cli.parse;

import org.github.palace.bot.enums.BaseCommandEnum;

import java.util.List;

/**
 * @author JHY
 * @date 2022/3/24 15:15
 */
public class DefaultParser {

    private List<String> args;

    /**
     * 跳过命令行解析
     */
    protected boolean skipParsing;
    protected BaseCommandEnum currentCommandLine;


    void parse(String... arguments) {
        skipParsing = false;

        if (arguments != null) {
            for (String argument : arguments) {
                handleToken(argument);
            }
        }
    }

    private void handleToken(String token) {

        if (skipParsing) {
            args.add(token);
        } else if (BaseCommandEnum.get(token) != null) {
            currentCommandLine = BaseCommandEnum.get(token);
            skipParsing = true;
        } else {
            handlerUnkown(token);
        }
    }

    private void handlerUnkown(String token) {

    }

}
