package com.patterns.service;

import com.patterns.controller.error.InvalidDataException;
import com.patterns.controller.error.NotFoundException;
import com.patterns.dto.TrainingPlanDTO;

import java.util.List;

public interface TrainingPlanService {
    void create(String title, String goalType) throws InvalidDataException;
    void delete(long id);
    List<TrainingPlanDTO> findAll();
    void updateTitle(Long id, String title) throws NotFoundException;
    void updateGoalType(Long id, String goalType) throws NotFoundException, InvalidDataException;
}
