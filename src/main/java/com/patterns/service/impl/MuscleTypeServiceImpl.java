package com.patterns.service.impl;

import com.patterns.database.model.type.TypeMuscle;
import com.patterns.database.repository.type.MuscleTypeRepository;
import com.patterns.dto.mapper.type.TypeMuscleMapper;
import com.patterns.dto.type.TypeMuscleDTO;
import com.patterns.service.MuscleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuscleTypeServiceImpl implements MuscleTypeService {
    private final MuscleTypeRepository repository;
    private final TypeMuscleMapper mapper;
    @Override
    public List<TypeMuscleDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
    }
}
