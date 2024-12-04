package com.patterns.task23;

import com.patterns.database.model.TrainingPlan;

public interface TrainingMetricCalculator {
    double calculateMetric(TrainingSession session);

}
