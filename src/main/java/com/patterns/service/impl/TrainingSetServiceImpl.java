package com.patterns.service.impl;

import com.patterns.database.repository.TrainingSetRepository;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.service.TrainingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingSetServiceImpl implements TrainingSetService {

    private final TrainingSetRepository repository;

    @Override
    public List<TrainingSetDTO> getTrainingSetsByExerciseId(long exerciseId) {
        return null;
    }
}
