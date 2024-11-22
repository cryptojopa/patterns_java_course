package com.patterns.service;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.type.TypeExercise;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingSetDTO;

import java.util.List;

public interface ExerciseService {
    List<ExerciseDTO> findByTrainingPlanId(Long planId);
    void create(TrainingPlan plan, TypeExercise typeExercise);
    void delete(Long id);
    ExerciseDTO findById(Long id) throws NotFoundException;
    void addSet(Long id,
                double weight,
                int reps,
                String intensity,
                String commentary) throws NotFoundException;
    List<TrainingSetDTO> findByExerciseId(Long exerciseId);
}
