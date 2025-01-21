package com.patterns.service;


import com.patterns.database.model.Exercise;
import com.patterns.dto.TrainingSetDTO;

import java.util.List;

public interface TrainingSetService {
    List<TrainingSetDTO> findByExerciseId(Long exerciseId);
    Long add(Exercise exercise, TrainingSetDTO trainingSetDTO);
    void update(Long id, Double weight, Integer reps, String intensity, String commentary);
}
