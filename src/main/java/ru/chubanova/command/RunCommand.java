package ru.chubanova.command;

import ru.chubanova.ioc.IoC;
import ru.chubanova.state.State;

public class RunCommand implements Command {

    @Override
    public void execute() {
        IoC.<ThreadLocal<State>>resolve("GameState").set(IoC.resolve("NormalState"));
    }

}
