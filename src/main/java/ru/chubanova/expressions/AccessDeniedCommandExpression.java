package ru.chubanova.expressions;


import ru.chubanova.command.Command;

import java.util.Map;
import java.util.Optional;

public class AccessDeniedCommandExpression implements Expression<Command> {
    @Override
    public Command interpret(ExpressionContext context) {
        return () -> Optional.ofNullable(context)
                .map(ExpressionContext::getAnswerConsumer)
                .orElseThrow(RuntimeException::new)
                .accept(Map.of("access", "denied"));
    }
}
