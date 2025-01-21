package com.patterns.service.impl;
import com.patterns.database.model.type.TypeIntensity;
import com.patterns.database.repository.type.IntensityTypeRepository;
import com.patterns.dto.mapper.type.TypeIntensityMapper;
import com.patterns.dto.type.TypeIntensityDTO;
import com.patterns.service.IntensityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntensityTypeServiceImpl implements IntensityTypeService {
    private final IntensityTypeRepository repository;
    private final TypeIntensityMapper mapper;
    @Override
    public List<TypeIntensityDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public TypeIntensity findByName(String name) {
        return repository.findByName(name).orElseThrow();
    }

}
