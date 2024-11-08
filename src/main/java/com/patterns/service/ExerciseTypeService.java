package com.patterns.service;

import com.patterns.database.model.type.ExerciseType;

import java.util.List;

public interface ExerciseTypeService {
    void add(String name);

    List<ExerciseType> findAll();

    void delete(Long id);

    ExerciseType findByName(String name);
}
