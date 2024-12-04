package com.patterns.task22;

public class CancelledState implements WorkoutState {
    @Override
    public void startWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot start a cancelled workout.");
    }

    @Override
    public void pauseWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot pause a cancelled workout.");
    }

    @Override
    public void resumeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot resume a cancelled workout.");
    }

    @Override
    public void completeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot complete a cancelled workout.");
    }

    @Override
    public void cancelWorkout(WorkoutSession session) {
        throw new IllegalStateException("Workout is already cancelled.");
    }
}

