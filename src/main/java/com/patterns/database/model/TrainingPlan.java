package com.patterns.database.model;


import com.patterns.database.model.exercise.Exercise;

import java.util.List;

/*Паттерн Prototype
* Паттерн SFM*/
public class TrainingPlan {
    private List<Exercise> exerciseList;

    private Goal goal;

    public TrainingPlan() {
    }

    private TrainingPlan(List<Exercise> exerciseList, Goal goal) {
    }

    public TrainingPlan replicate(){
        return new TrainingPlan(this.exerciseList, this.goal);
    }

//    public static TrainingPlan getDefaultTrainingPlan() {
//        List<Exercise> exercises = new ArrayList<>();
//        exercises.add(Exercise.DUMBBELL_PRESS);
//        exercises.add(Exercise.BARBELL_SQUAT);
//        exercises.add(Exercise.BARBELL_CURLS);
//        return new TrainingPlan(exercises, Goal.HYPERTROPHY);
//    }
//
//    public static TrainingPlan getChestTrainingPlan() {
//        List<Exercise> exercises = new ArrayList<>();
//        exercises.add(Exercise.DUMBBELL_PRESS);
//        exercises.add(Exercise.BENCH_PRESS);
//        return new TrainingPlan(exercises, Goal.HYPERTROPHY);
//    }
//
//    public static TrainingPlan getArmsTrainingPlan() {
//        List<Exercise> exercises = new ArrayList<>();
//        exercises.add(Exercise.BARBELL_CURLS);
//        exercises.add(Exercise.FRENCH_PRESS);
//        return new TrainingPlan(exercises, Goal.HYPERTROPHY);
//    }
}
