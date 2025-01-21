package com.patterns.service;

import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.dto.type.ExerciseCutDTO;

import java.util.List;

public interface TrainingPlanService {
    Long create(String title, String goalType);
    void delete(Long id);
    List<TrainingPlanCutDTO> findAll();
    TrainingPlanCutDTO update(Long id, String title, String goal);
    TrainingPlanDTO findById(Long id);
    List<ExerciseCutDTO> findExercisesByPlanId(Long id);
    Long addExercise(Long planId, String exerciseType);
}
