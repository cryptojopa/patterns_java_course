package com.patterns.service;

import com.patterns.database.model.type.TypeMuscle;

import java.util.List;

public interface MuscleTypeService {
    List<TypeMuscle> findAll();
}
