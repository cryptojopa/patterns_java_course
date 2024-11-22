package com.patterns.service.impl;

import com.patterns.database.model.type.TypeMuscle;
import com.patterns.database.repository.type.MuscleTypeRepository;
import com.patterns.service.MuscleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuscleTypeServiceImpl implements MuscleTypeService {
    private final MuscleTypeRepository repository;

    @Override
    public List<TypeMuscle> findAll() {
        return repository.findAll();
    }
}
