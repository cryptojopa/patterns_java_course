package com.patterns.task23;

import lombok.Setter;

@Setter
public class TrainingService {
    private TrainingMetricCalculator calculator;

    public void setCalculator(TrainingMetricCalculator calculator) {
        this.calculator = calculator;
    }

    public double calculateMetric(TrainingSession session) {
        if (calculator == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return calculator.calculateMetric(session);
    }
}
