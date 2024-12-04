package com.patterns.task22;

public class PlannedState implements WorkoutState {
    @Override
    public void startWorkout(WorkoutSession session) {
        session.setState(new InProgressState());
        System.out.println("Workout started!");
    }

    @Override
    public void pauseWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot pause a planned workout.");
    }

    @Override
    public void resumeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot resume a planned workout.");
    }

    @Override
    public void completeWorkout(WorkoutSession session) {
        throw new IllegalStateException("Cannot complete a planned workout.");
    }

    @Override
    public void cancelWorkout(WorkoutSession session) {
        session.setState(new CancelledState());
        System.out.println("Workout cancelled.");
    }
}


