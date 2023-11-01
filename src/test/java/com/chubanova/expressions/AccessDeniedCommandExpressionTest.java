package com.chubanova.expressions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.chubanova.command.Command;
import ru.chubanova.entity.AnswerConsumer;
import ru.chubanova.expressions.AccessDeniedCommandExpression;
import ru.chubanova.expressions.Expression;
import ru.chubanova.expressions.ExpressionContext;


import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccessDeniedCommandExpressionTest {

    @Mock
    private ExpressionContext context;
    @Mock
    private AnswerConsumer answerConsumer;

    private Expression<Command> expression;

    @BeforeEach
    void setUp() {
        expression = new AccessDeniedCommandExpression();
    }

    @Test
    void interpret() {
        when(context.getAnswerConsumer()).thenReturn(answerConsumer);

        expression.interpret(context).execute();

        verify(context, times(1)).getAnswerConsumer();
        verify(answerConsumer, times(1)).accept(Map.of("access", "denied"));
    }
}