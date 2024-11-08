package com.patterns.service;


import com.patterns.dto.TrainingSetDTO;

import java.util.List;

public interface TrainingSetService {
    List<TrainingSetDTO> getTrainingSetsByExerciseId(long exerciseId);

    void addTrainingSet(String exercise, double weight, int reps, String intensity, String commentary);
}
