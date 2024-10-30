package com.patterns.service;


import com.patterns.dto.TrainingSetDTO;

import java.util.List;

public interface TrainingSetService {
    List<TrainingSetDTO> getTrainingSetsByExerciseId(long exerciseId);
}
