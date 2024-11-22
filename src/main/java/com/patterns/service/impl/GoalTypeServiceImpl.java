package com.patterns.service.impl;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.type.TypeGoal;
//import com.patterns.database.repository.type.GoalTypeRepository;
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
    public List<TypeGoal> findAll() {
        return repository.findAll();
    }

    @Override
    public TypeGoal findByName(String name) throws NotFoundException {
        return repository.findByName(name).orElseThrow(NotFoundException::new);
    }
}
