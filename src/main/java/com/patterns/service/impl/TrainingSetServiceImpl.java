package com.patterns.service.impl;

import com.patterns.database.model.TrainingSet;
import com.patterns.database.repository.TrainingSetRepository;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.dto.mapper.TrainingSetMapper;
import com.patterns.service.TrainingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingSetServiceImpl implements TrainingSetService {
    private final TrainingSetRepository trainingSetRepository;
    private final TrainingSetMapper mapper;

    @Override
    public List<TrainingSetDTO> getTrainingSetsByExerciseId(long exerciseId) {
        return trainingSetRepository.findByExerciseId(exerciseId).stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public void addTrainingSet(String exercise, double weight, int reps, String intensity, String commentary) {

    }

    @Override
    public List<TrainingSet> findAll() {
        return trainingSetRepository.findAll();
    }
}
