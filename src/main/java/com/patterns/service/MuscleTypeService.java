package com.patterns.service;

import com.patterns.database.model.type.TypeMuscle;
import com.patterns.dto.type.TypeMuscleDTO;

import java.util.List;

public interface MuscleTypeService {
    List<TypeMuscleDTO> findAll();
}
