package com.patterns.task23;

public class StrengthMetricCalculator implements TrainingMetricCalculator {
    @Override
    public double calculateMetric(TrainingSession session) {
        return session.getSets() * session.getWeight() * 0.5;
    }
}
