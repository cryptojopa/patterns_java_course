package com.patterns.dto;

public record TrainingSetDTO(
        Long id,
        String exercise,
        Double weight,
        Integer reps,
        String intensity,
        String commentary) {

}
