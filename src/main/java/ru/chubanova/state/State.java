package ru.chubanova.state;

import ru.chubanova.command.Command;

import java.util.Queue;

public interface State {

   State handle(Queue<Command> commands);

}
