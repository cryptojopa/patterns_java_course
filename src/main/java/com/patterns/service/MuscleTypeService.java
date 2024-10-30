package com.patterns.service;

import com.patterns.database.model.type.ExerciseType;
import com.patterns.database.model.type.MuscleType;

import java.util.List;

public interface MuscleTypeService {
    void add(String name);

    List<MuscleType> findAll();

    void delete(Long id);
}
