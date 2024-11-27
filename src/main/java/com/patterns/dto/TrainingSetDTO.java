package com.patterns.dto;

import com.patterns.database.model.type.TypeIntensity;

public record TrainingSetDTO(
        Long id,
        String exercise,
        Double weight,
        Integer reps,
        String intensity,
        String commentary) {

}
