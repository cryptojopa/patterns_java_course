package com.patterns.database.model.exercise.eng;

import com.patterns.exception.UnknownTypeException;

/* Реализует паттерн Factory Method*/
public class ExerciseFactory {
    public Exercise createExercise(ExerciseType type) throws UnknownTypeException {
        switch (type) {
            case BENCH_PRESS -> {
                return new BenchPressEng();
            }
            case BARBELL_SQUAT -> {
                return new BarbellSquatsEng();
            }
            default -> throw new UnknownTypeException();
        }
    }
}
