package ru.chubanova.expressions;

public interface Expression<T> {

    T interpret(ExpressionContext context);


}
