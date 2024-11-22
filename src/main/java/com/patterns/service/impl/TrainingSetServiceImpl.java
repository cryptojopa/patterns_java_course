package com.patterns.service.impl;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.Exercise;
import com.patterns.database.model.TrainingSet;
import com.patterns.database.model.type.TypeIntensity;
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
    public List<TrainingSetDTO> findByExerciseId(long exerciseId) {
        return repository.findByExerciseId(exerciseId).stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public void add(Exercise exercise, Double weight, Integer reps, String intensity, String commentary) {
        try {
            TypeIntensity typeIntensity = intensityTypeService.findByName(intensity);
            TrainingSet set = TrainingSet.builder()
                    .exercise(exercise)
                    .weight(weight)
                    .reps(reps)
                    .intensity(typeIntensity)
                    .commentary(commentary)
                    .build();
            repository.save(set);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id, Double weight, Integer reps, String intensity, String commentary) throws NotFoundException {
        try {
            TrainingSet set = repository.findById(id).orElseThrow(NotFoundException::new);
            repository.update(id, weight, reps, commentary);
        } catch (NotFoundException e) {
            throw new RuntimeException("TrainingSet not found", e);
        }
    }
}
