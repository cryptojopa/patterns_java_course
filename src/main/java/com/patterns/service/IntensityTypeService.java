package com.patterns.service;

import com.patterns.database.model.type.TypeIntensity;

import java.util.List;

public interface IntensityTypeService {
    List<TypeIntensity> findAll();
    TypeIntensity findByName(String name);
}
