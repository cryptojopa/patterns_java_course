package com.patterns.model;


import java.util.ArrayList;
import java.util.List;

/*Паттерн Prototype
* Паттерн SFM*/
public class TrainingPlan {
    private List<Exercise> exerciseList;

    public TrainingPlan() {
    }

    private TrainingPlan(List<Exercise> exerciseList) {
    }

    public TrainingPlan replicate(){
        return new TrainingPlan(this.exerciseList);
    }

    public static TrainingPlan getDefaultTrainingPlan() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(Exercise.DUMBBELL_PRESS);
        exercises.add(Exercise.BARBELL_SQUAT);
        exercises.add(Exercise.BARBELL_CURLS);
        return new TrainingPlan(exercises);
    }

    public static TrainingPlan getChestTrainingPlan() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(Exercise.DUMBBELL_PRESS);
        exercises.add(Exercise.BENCH_PRESS);
        return new TrainingPlan(exercises);
    }

    public static TrainingPlan getArmsTrainingPlan() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(Exercise.BARBELL_CURLS);
        exercises.add(Exercise.FRENCH_PRESS);
        return new TrainingPlan(exercises);
    }
}
