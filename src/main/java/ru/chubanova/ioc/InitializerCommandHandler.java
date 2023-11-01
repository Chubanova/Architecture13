package ru.chubanova.ioc;


import ru.chubanova.command.Command;
import ru.chubanova.ioc.command.ChangeScopeCommand;
import ru.chubanova.ioc.command.CreateScopeCommand;
import ru.chubanova.ioc.command.RegisterCommand;

public class InitializerCommandHandler implements Initializer<IoCDictionary<Command>> {
    @Override
    public void initialize(IoCDictionary<Command> handler) {
        handler.add("IoC.Register",
                RegisterCommand::new);

        handler.add("Scopes.New",
                CreateScopeCommand::new);

        handler.add("Scopes.Current",
                ChangeScopeCommand::new);
    }
}