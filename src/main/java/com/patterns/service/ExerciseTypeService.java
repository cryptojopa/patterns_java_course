package com.patterns.service;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.type.TypeExercise;

import java.util.List;

public interface ExerciseTypeService {
    void add(String name, String muscle) throws NotFoundException;

    List<TypeExercise> findAll();

    void delete(Long id);

    TypeExercise findByName(String name) throws NotFoundException;
}
