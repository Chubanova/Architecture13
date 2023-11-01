package ru.chubanova.expressions;


import ru.chubanova.entity.AnswerConsumer;
import ru.chubanova.entity.Message;

import java.util.function.BiFunction;

public class ExpressionContextImpl implements ExpressionContext {

    private final BiFunction<String, Object[], Object> dependencyIoCStrategy;
    private final Message message;
    private final AnswerConsumer answerConsumer;


    public ExpressionContextImpl(
            BiFunction<String, Object[], Object> dependencyIoCStrategy,
            Message message,
            AnswerConsumer answerConsumer) {
        this.dependencyIoCStrategy = dependencyIoCStrategy;
        this.message = message;
        this.answerConsumer = answerConsumer;
    }

    @Override
    public Object resolve(String name, Object... args) {
        return dependencyIoCStrategy.apply(name, args);
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public AnswerConsumer getAnswerConsumer() {
        return answerConsumer;
    }


}
