package com.patterns.service;

import com.patterns.database.model.type.TypeExercise;
import com.patterns.dto.type.TypeExerciseDTO;

import java.util.List;

public interface ExerciseTypeService {
    Long add(String name, String muscle);
    List<TypeExerciseDTO> findAll();
    void delete(Long id);
    TypeExerciseDTO findByNameToDTO(String name);
    TypeExercise findByName(String name);
}
