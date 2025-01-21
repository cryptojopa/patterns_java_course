package com.patterns.service;

import com.patterns.database.model.type.TypeGoal;
import com.patterns.dto.type.TypeGoalDTO;

import java.util.List;

public interface GoalTypeService {
    List<TypeGoalDTO> findAll();
    TypeGoalDTO findByNameDTO(String name);
    TypeGoal findByName(String name);
}
