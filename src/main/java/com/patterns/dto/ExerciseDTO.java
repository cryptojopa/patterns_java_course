package com.patterns.dto;

import com.patterns.database.model.TrainingSet;

import java.util.List;

public record ExerciseDTO(
        Long id,
        String plan,
        List<TrainingSet> trainingSets,
        String targetMuscle,
        String exerciseType
) {
}
