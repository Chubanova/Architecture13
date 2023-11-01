package com.chubanova;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.chubanova.Tank;
import ru.chubanova.command.Command;
import ru.chubanova.command.InterpretCommand;
import ru.chubanova.command.PrintCommand;
import ru.chubanova.ioc.IoC;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class InterpretCommandTest {

    private Queue<Command> gameCommands;


    @Test
    public void executeTest() {
        gameCommands = new LinkedBlockingQueue<>();

        try (MockedStatic<IoC> utilities = Mockito.mockStatic(IoC.class)) {
            utilities.when(() -> IoC.resolve("GameObject", 1L))
                    .thenReturn(new Tank());
            utilities.when(() -> IoC.resolve(eq("Operation"), any()))
                    .thenReturn(new PrintCommand(10));
            InterpretCommand interpretCommand = new InterpretCommand(1L, 2L, 3L, new String[]{"10"}, gameCommands);
            interpretCommand.execute();
            Assertions.assertThat(gameCommands)
                    .hasSize(1)
                    .allMatch(command -> command instanceof PrintCommand
                            && ((PrintCommand) command).getIdCommand() == 10);
        }
    }
}
