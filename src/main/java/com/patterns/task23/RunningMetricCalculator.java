package com.patterns.task23;

public class RunningMetricCalculator implements TrainingMetricCalculator {
    @Override
    public double calculateMetric(TrainingSession session) {
        return session.getDuration() * session.getSpeed() * 0.75;
    }
}
