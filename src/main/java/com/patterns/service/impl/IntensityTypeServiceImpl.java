package com.patterns.service.impl;
import com.patterns.database.model.type.IntensityType;
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
    public void add(String name) {
        if (repository.findByName(name).isEmpty()) {
            IntensityType exerciseType = new IntensityType();
            exerciseType.setName(name.trim());
            repository.save(exerciseType);
        }
    }

    @Override
    public List<IntensityType> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
