package com.patterns.service.impl;

import com.patterns.database.model.Exercise;
import com.patterns.database.model.TrainingSet;
import com.patterns.database.repository.TrainingSetRepository;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.dto.mapper.TrainingSetMapper;
import com.patterns.service.IntensityTypeService;
import com.patterns.service.TrainingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingSetServiceImpl implements TrainingSetService {
    private final TrainingSetRepository repository;
    private final IntensityTypeService intensityTypeService;
    private final TrainingSetMapper mapper;

    @Override
    public List<TrainingSetDTO> findByExerciseId(Long exerciseId) {
        return repository.findByExerciseId(exerciseId).stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public Long add(Exercise exercise, TrainingSetDTO trainingSetDTO) {
        TrainingSet set = mapper.convertToEntity(trainingSetDTO, exercise);
        return repository.save(set).getId();
    }

    @Override
    public void update(Long id, Double weight, Integer reps, String intensity, String commentary) {
            repository.update(id,
                    weight,
                    reps,
                    intensityTypeService.findByName(intensity),
                    commentary);
    }
}
