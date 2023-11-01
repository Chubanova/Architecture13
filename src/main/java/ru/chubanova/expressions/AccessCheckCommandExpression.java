package ru.chubanova.expressions;


import ru.chubanova.command.Command;

public class AccessCheckCommandExpression implements Expression<Command> {

    private final Expression<Command> success;
    private final Expression<Command> failure;

    public AccessCheckCommandExpression(Expression<Command> success, Expression<Command> failure) {
        this.success = success;
        this.failure = failure;
    }

    @Override
    public Command interpret(ExpressionContext context) {
        if ((boolean) context.resolve("User.GameObject::hasAccess", context.getMessage())) {
            return success.interpret(context);
        } else {
            return failure.interpret(context);
        }
    }
}
