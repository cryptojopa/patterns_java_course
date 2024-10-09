package com.patterns.factory;

import com.patterns.database.model.exercise.eng.BenchPressEng;
import com.patterns.database.model.exercise.Exercise;
import com.patterns.factory.interfaces.AbstractExerciseFactory;

public class EngExerciseFactory implements AbstractExerciseFactory {
    @Override
    public Exercise createBenchPressExercise() {
        return new BenchPressEng();
    }

    @Override
    public Exercise createBarbellSquatsExercise() {
        return new BenchPressEng();
    }
}
