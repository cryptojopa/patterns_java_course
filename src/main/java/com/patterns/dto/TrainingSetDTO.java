package com.patterns.dto;

public record TrainingSetDTO(
        long id,
        String exercise,
        double weight,
        int reps,
        String intensity,
        String commentary){}
