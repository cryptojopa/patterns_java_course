package com.patterns.service.impl;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.Exercise;
import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.type.TypeExercise;
import com.patterns.database.repository.ExerciseRepository;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.dto.mapper.ExerciseMapper;
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
    public List<ExerciseDTO> findByTrainingPlanId(Long planId) {
        return repository.findByTrainingPlanId(planId).stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public void create(TrainingPlan plan, TypeExercise typeExercise) {
        Exercise exercise = new Exercise();
        exercise.setExerciseType(typeExercise);
        exercise.setPlan(plan);
        repository.save(exercise);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ExerciseDTO findById(Long id) throws NotFoundException {
        return repository.findById(id).map(mapper::convertToDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public void addSet(Long id, double weight, int reps, String intensity, String commentary) throws NotFoundException {
        Exercise exercise = repository.findById(id).orElseThrow(NotFoundException::new);
        trainingSetService.add(exercise,
                weight,
                reps,
                intensity,
                commentary);
    }

    @Override
    public List<TrainingSetDTO> findByExerciseId(Long exerciseId) {
        return trainingSetService.findByExerciseId(exerciseId);
    }
}
