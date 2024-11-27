package com.patterns.dto;

import java.util.List;

public record TrainingPlanDTO(
        Long id,
        String title,
        String goal,
        List<ExerciseDTO> exercises) {
}
