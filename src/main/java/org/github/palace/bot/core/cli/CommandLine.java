package org.github.palace.bot.core.cli;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.LockSupport;

/**
 * @author JHY
 * @date 2022/3/25 7:31
 */
public class CommandLine {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private State state;

    public enum State {
        NEW,
        RUNNABLE,
        PREPARE,
        FINISH,
        CRASH
    }

    public CommandLine(String name, State state) {
        this.name = name;
        this.state = state;
    }
}
