package com.patterns.factory;

import com.patterns.database.model.exercise.ru.BarbellSquatsRu;
import com.patterns.database.model.exercise.ru.BenchPressRu;
import com.patterns.database.model.exercise.Exercise;
import com.patterns.factory.interfaces.AbstractExerciseFactory;

public class RuExerciseFactory implements AbstractExerciseFactory {
    @Override
    public Exercise createBenchPressExercise() {
        return new BenchPressRu();
    }

    @Override
    public Exercise createBarbellSquatsExercise() {
        return new BarbellSquatsRu();
    }
}
