package com.patterns.service;

import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.type.TypeExercise;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.dto.type.ExerciseCutDTO;

import java.util.List;

public interface ExerciseService {
    List<ExerciseCutDTO> findByTrainingPlanId(Long planId);
    Long create(TrainingPlan plan, TypeExercise typeExercise);
    void delete(Long id);
    ExerciseDTO findById(Long id);
    Long addSet(Long id, TrainingSetDTO trainingSetDTO);
    List<TrainingSetDTO> findByExerciseId(Long exerciseId);
}
