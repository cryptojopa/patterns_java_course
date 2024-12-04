package com.patterns.service;

import com.patterns.controller.error.NotFoundException;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;

import java.util.List;

public interface TrainingPlanService {
    void create(String title, String goalType);
    void delete(Long id);
    List<TrainingPlanCutDTO> findAll();
//    void updateTitle(Long id, String title);
//    void updateGoalType(Long id, String goalType);
    void update(Long id, TrainingPlanDTO planDTO);
    TrainingPlanDTO findById(Long id);
    List<ExerciseDTO> findExercisesByPlanId(Long id);
    void addExercise(Long planId, String exerciseType);
}
