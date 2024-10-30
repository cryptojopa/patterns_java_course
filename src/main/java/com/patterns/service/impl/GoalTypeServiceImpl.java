package com.patterns.service.impl;

import com.patterns.database.model.type.GoalType;
import com.patterns.database.repository.type.GoalTypeRepository;
import com.patterns.service.GoalTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalTypeServiceImpl implements GoalTypeService {
    private final GoalTypeRepository repository;

    @Override
    public List<GoalType> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void add(String name) {
        if (repository.findByName(name).isEmpty()) {
            GoalType goalType = new GoalType();
            goalType.setName(name.trim());
            repository.save(goalType);
        }
    }
}
