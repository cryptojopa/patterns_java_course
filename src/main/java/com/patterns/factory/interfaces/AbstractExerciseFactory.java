package com.patterns.factory.interfaces;

import com.patterns.database.model.exercise.Exercise;

/* Реализован паттерн Abstract Factory*/
public interface AbstractExerciseFactory {
    Exercise createBenchPressExercise();
    Exercise createBarbellSquatsExercise();
}
