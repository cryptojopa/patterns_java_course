package com.patterns.task22;

public interface WorkoutState {
    void startWorkout(WorkoutSession session);
    void pauseWorkout(WorkoutSession session);
    void resumeWorkout(WorkoutSession session);
    void completeWorkout(WorkoutSession session);
    void cancelWorkout(WorkoutSession session);
}
