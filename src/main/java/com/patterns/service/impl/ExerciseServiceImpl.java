package com.patterns.service.impl;

import com.patterns.database.model.Exercise;
import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.type.TypeExercise;
import com.patterns.database.repository.ExerciseRepository;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.dto.mapper.ExerciseMapper;
import com.patterns.dto.type.ExerciseCutDTO;
import com.patterns.service.ExerciseService;
import com.patterns.service.TrainingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final TrainingSetService trainingSetService;
    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    @Override
    public List<ExerciseCutDTO> findByTrainingPlanId(Long planId) {
        return repository.findByTrainingPlanId(planId).stream().map(mapper::convertToCutDTO).toList();
    }

    @Override
    public Long create(TrainingPlan plan, TypeExercise exerciseType) {
        Exercise exercise = new Exercise(exerciseType, plan);
        return repository.save(exercise).getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ExerciseDTO findById(Long id) {
        return repository.findById(id).map(mapper::convertToDTO)
                .orElseGet(() -> new Exercise().map(mapper::convertToDTO));
    }

    //надо доделать штуку с возвратом дто сета
    @Override
    public Long addSet(Long exerciseId, TrainingSetDTO trainingSetDTO){
        Exercise exercise = repository.findById(exerciseId).orElseThrow();
        return trainingSetService.add(exercise, trainingSetDTO);
    }

    @Override
    public List<TrainingSetDTO> findByExerciseId(Long exerciseId) {
        return trainingSetService.findByExerciseId(exerciseId);
    }
}
