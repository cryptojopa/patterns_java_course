package com.patterns.service.impl;

//import com.patterns.database.repository.type.GoalTypeRepository;
import com.patterns.database.model.type.TypeGoal;
import com.patterns.database.repository.type.GoalTypeRepository;
import com.patterns.dto.mapper.type.TypeGoalMapper;
import com.patterns.dto.type.TypeGoalDTO;
import com.patterns.service.GoalTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalTypeServiceImpl implements GoalTypeService {
    private final GoalTypeRepository repository;
    private final TypeGoalMapper mapper;

    @Override
    public List<TypeGoalDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public TypeGoalDTO findByNameDTO(String name){
        return repository.findByName(name).map(mapper::convertToDTO).orElseThrow();
    }

    @Override
    public TypeGoal findByName(String name){
        return repository.findByName(name).orElse(null);
    }
}
