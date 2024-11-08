package com.patterns.service.impl;

import com.patterns.database.model.type.ExerciseType;
import com.patterns.database.repository.type.ExerciseTypeRepository;
import com.patterns.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseTypeServiceImpl implements ExerciseTypeService {
    private final ExerciseTypeRepository repository;

    @Override
    public List<ExerciseType> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ExerciseType findByName(String name) {
        return repository.findByName(name).get();
    }

    @Override
    public void add(String name) {
        if (repository.findByName(name).isEmpty()) {
            ExerciseType exerciseType = new ExerciseType();
            exerciseType.setName(name.trim());
            repository.save(exerciseType);
        }
    }
}
