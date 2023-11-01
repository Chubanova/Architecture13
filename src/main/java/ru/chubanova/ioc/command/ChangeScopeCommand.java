package ru.chubanova.ioc.command;

import ru.chubanova.command.Command;
import ru.chubanova.ioc.ScopeDictionary;
import ru.chubanova.ioc.ScopeDictionaryImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangeScopeCommand implements Command {

    private final Object[] args;

    @Override
    public void execute() {
        ScopeDictionary scopesDictionary = ScopeDictionaryImpl.getInstance();
        scopesDictionary.changeScope(String.valueOf(args[0]));
    }

}
