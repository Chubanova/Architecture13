package ru.chubanova.command;

import ru.chubanova.ioc.IoC;
import ru.chubanova.state.State;

public class HardStopCommand implements Command {

    @Override
    public void execute() {
        IoC.<ThreadLocal<State>>resolve("GameState").remove();
    }

}
