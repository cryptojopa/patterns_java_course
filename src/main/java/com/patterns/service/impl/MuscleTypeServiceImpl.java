package com.patterns.service.impl;

import com.patterns.database.model.type.MuscleType;
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
    public void add(String name) {
        if (repository.findByName(name).isEmpty()) {
            MuscleType muscleType = new MuscleType();
            muscleType.setName(name.trim());
            repository.save(muscleType);
        }
    }

    @Override
    public List<MuscleType> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
