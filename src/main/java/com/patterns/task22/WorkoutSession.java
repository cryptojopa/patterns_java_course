package com.patterns.task22;

import lombok.Setter;

@Setter
public class WorkoutSession {
    private WorkoutState state;

    public WorkoutSession() {
        this.state = new PlannedState(); // Начальное состояние
    }

    public void startWorkout() {
        state.startWorkout(this);
    }

    public void pauseWorkout() {
        state.pauseWorkout(this);
    }

    public void resumeWorkout() {
        state.resumeWorkout(this);
    }

    public void completeWorkout() {
        state.completeWorkout(this);
    }

    public void cancelWorkout() {
        state.cancelWorkout(this);
    }
}

