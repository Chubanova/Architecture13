package ru.chubanova.expressions;


import ru.chubanova.entity.AnswerConsumer;
import ru.chubanova.entity.Message;

public interface ExpressionContextFactory {

    ExpressionContext create(Message message, AnswerConsumer consumer);
}
