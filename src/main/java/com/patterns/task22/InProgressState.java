package com.patterns.task22;

public class InProgressState implements WorkoutState {
    @Override
    public void startWorkout(WorkoutSession session) {
        throw new IllegalStateException("Workout is already in progress.");
    }

    @Override
    public void pauseWorkout(WorkoutSession session) {
        session.setState(new PausedState());
        System.out.println("Workout paused.");
    }

    @Override
    public void resumeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Workout is already in progress.");
    }

    @Override
    public void completeWorkout(WorkoutSession session) {
        session.setState(new CompletedState());
        System.out.println("Workout completed!");
    }

    @Override
    public void cancelWorkout(WorkoutSession session) {
        session.setState(new CancelledState());
        System.out.println("Workout cancelled.");
    }
}
