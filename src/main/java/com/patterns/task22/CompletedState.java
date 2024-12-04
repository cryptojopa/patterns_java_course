package com.patterns.task22;

public class CompletedState implements WorkoutState {
    @Override
    public void startWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot start a completed workout.");
    }

    @Override
    public void pauseWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot pause a completed workout.");
    }

    @Override
    public void resumeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot resume a completed workout.");
    }

    @Override
    public void completeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Workout is already completed.");
    }

    @Override
    public void cancelWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot cancel a completed workout.");
    }
}

