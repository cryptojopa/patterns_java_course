package com.patterns.service;

import com.patterns.database.model.type.TypeIntensity;
import com.patterns.dto.type.TypeIntensityDTO;

import java.util.List;

public interface IntensityTypeService {
    List<TypeIntensityDTO> findAll();
    TypeIntensity findByName(String name);
}
