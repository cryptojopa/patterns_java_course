package com.patterns.service;

import com.patterns.database.model.type.IntensityType;

import java.util.List;

public interface IntensityTypeService {
    void add(String name);

    List<IntensityType> findAll();

    void delete(Long id);
}
