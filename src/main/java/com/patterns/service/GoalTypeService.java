package com.patterns.service;

import com.patterns.controller.error.InvalidDataException;
import com.patterns.database.model.type.GoalType;

import java.util.List;

public interface GoalTypeService {
    void add(String name);
    List<GoalType> findAll();
    void delete(Long id);
    GoalType findByName(String name) throws InvalidDataException;
}
