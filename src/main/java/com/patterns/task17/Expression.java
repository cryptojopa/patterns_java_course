package com.patterns.task17;

import com.patterns.database.model.TrainingSet;

/* Интерфейс Expression */

public interface Expression {
    boolean interpret(TrainingSet trainingPlan);
}
