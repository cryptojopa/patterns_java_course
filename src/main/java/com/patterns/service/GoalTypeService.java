package com.patterns.service;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.type.TypeGoal;

import java.util.List;

public interface GoalTypeService {
    List<TypeGoal> findAll();
    TypeGoal findByName(String name) throws NotFoundException;
}
