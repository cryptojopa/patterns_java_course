package com.patterns.service;


import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.Exercise;
import com.patterns.dto.TrainingSetDTO;

import java.util.List;

public interface TrainingSetService {
    List<TrainingSetDTO> findByExerciseId(Long exerciseId);
    void add(Exercise exercise, Double weight, Integer reps, String intensity, String commentary);
    void update(Long id, Double weight, Integer reps, String intensity, String commentary) throws NotFoundException;
}
