package ru.chubanova.expressions;

public class ActionNameExpression implements Expression<String> {

    @Override
    public String interpret(ExpressionContext context) {
        return context.resolve("IoC.Game::getActionName", context.getMessage());
    }
}
