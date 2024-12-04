package com.patterns.task22;

public class PausedState implements WorkoutState {
    @Override
    public void startWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot start a paused workout.");
    }

    @Override
    public void pauseWorkout(WorkoutSession session) {
        throw new IllegalStateException("Workout is already paused.");
    }

    @Override
    public void resumeWorkout(WorkoutSession session) {
        session.setState(new InProgressState());
        System.out.println("Workout resumed!");
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

