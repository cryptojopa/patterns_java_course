package com.patterns.service.impl;
import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.type.TypeIntensity;
//import com.patterns.database.repository.type.IntensityTypeRepository;
import com.patterns.database.repository.type.IntensityTypeRepository;
import com.patterns.service.IntensityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntensityTypeServiceImpl implements IntensityTypeService {
    private final IntensityTypeRepository repository;
    @Override
    public List<TypeIntensity> findAll() {
        return repository.findAll();
    }

    @Override
    public TypeIntensity findByName(String name) throws NotFoundException {
        return repository.findByName(name).orElseThrow(NotFoundException::new);
    }

}
