package com.patterns.database.model.exercise.ru;

import com.patterns.database.model.exercise.Exercise;
import com.patterns.exception.UnknownTypeException;

/* Реализует паттерн Factory Method*/
public class ExerciseFactory {
    public Exercise createExercise(ExerciseType type) throws UnknownTypeException {
        switch (type) {
            case BENCH_PRESS -> {
                return new BenchPressRu();
            }
            case BARBELL_SQUAT -> {
                return new BarbellSquatsRu();
            }
            default -> throw new UnknownTypeException();
        }
    }
}
