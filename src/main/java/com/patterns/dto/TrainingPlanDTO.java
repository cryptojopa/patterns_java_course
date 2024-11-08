package com.patterns.dto;

import com.patterns.database.model.Exercise;

import java.util.List;

public record TrainingPlanDTO(
        Long id,
        String title,
        String goalType,
        List<Exercise> exerciseList
) {
}
