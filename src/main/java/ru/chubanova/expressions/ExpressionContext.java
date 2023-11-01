package ru.chubanova.expressions;


import ru.chubanova.entity.AnswerConsumer;
import ru.chubanova.entity.Message;

public interface ExpressionContext {

    <T> T resolve(String name, Object... args);

    Message getMessage();

    AnswerConsumer getAnswerConsumer();

}
