package com.patterns.service;

import com.patterns.controller.error.NotFoundException;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;

import java.util.List;

public interface TrainingPlanService {
    void create(String title, String goalType) throws NotFoundException;
    void delete(long id);
    List<TrainingPlanCutDTO> findAll();
    void updateTitle(Long id, String title) throws NotFoundException;
    void updateGoalType(Long id, String goalType) throws NotFoundException;
    TrainingPlanDTO findById(Long id) throws NotFoundException;
    List<ExerciseDTO> findExercisesByPlanId(Long id);
    void addExercise(Long planId, String exerciseType) throws NotFoundException;
}
