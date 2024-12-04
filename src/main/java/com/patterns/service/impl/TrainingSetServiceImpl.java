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
    public List<TrainingSetDTO> findByExerciseId(Long exerciseId) {
        return repository.findByExerciseId(exerciseId).stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public void add(Exercise exercise, Double weight, Integer reps, String intensity, String commentary) {
            TypeIntensity typeIntensity = intensityTypeService.findByName(intensity);
            TrainingSet set = new TrainingSet()
            set.setExercise(exercise);
            set.setWeight(weight);
            set.setReps(reps);
            set.setIntensity()
            set.setCommentary(commentary);
            repository.save(set);
    }

    @Override
    public void update(Long id, Double weight, Integer reps, String intensity, String commentary) {
            TrainingSet set = repository.findById(id).;
            repository.update(id, weight, reps, commentary);
        } catch (NotFoundException e) {
            throw new RuntimeException("TrainingSet not found", e);
        }
    }
}
