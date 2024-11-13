package com.patterns.task17;

import com.patterns.database.model.TrainingSet;

/* Терминальное выражение */

public class WeightExpression implements Expression{
    private final double weight;

    public WeightExpression(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean interpret(TrainingSet trainingSet) {
        return trainingSet.getWeight() >= weight;
    }
}
