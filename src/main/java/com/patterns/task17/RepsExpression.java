package com.patterns.task17;

import com.patterns.database.model.TrainingSet;

/* Терминальное выражение */

public class RepsExpression implements Expression {
    private final int minReps;

    public RepsExpression(int minReps) {
        this.minReps = minReps;
    }

    @Override
    public boolean interpret(TrainingSet trainingSet) {
        return trainingSet.getReps() >= minReps;
    }
}
