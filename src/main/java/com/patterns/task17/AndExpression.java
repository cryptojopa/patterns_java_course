package com.patterns.task17;

import com.patterns.database.model.TrainingSet;

/* Нетерминальное Выражение */

public class AndExpression implements Expression{
    private final Expression expr1;
    private final Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(TrainingSet trainingPlan) {
        return expr1.interpret(trainingPlan) && expr2.interpret(trainingPlan);
    }
}
