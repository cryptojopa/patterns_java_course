package com.patterns.service;

import com.patterns.database.model.type.GoalType;

import java.util.List;

public interface GoalTypeService {
    void add(String name);

    List<GoalType> findAll();

    void delete(Long id);
}
