package com.patterns.database.model.exercise;

import com.patterns.exception.UnknownTypeException;

/* Реализует паттерн Factory Method*/
public class ExerciseFactory {
    public Exercise createExercise(ExerciseType type) throws UnknownTypeException {
        switch (type) {
            case BENCH_PRESS -> {
                return new BenchPress();
            }
            case BARBELL_SQUAT -> {
                return new BarbellSquats();
            }
            default -> throw new UnknownTypeException();
        }
    }
}
