package com.patterns.dto;

import com.patterns.database.model.TrainingSet;

import java.util.List;

public record ExerciseDTO(
        Long id,
        String targetMuscle,
        String exerciseType,
        List<TrainingSet> trainingSets) {
}
