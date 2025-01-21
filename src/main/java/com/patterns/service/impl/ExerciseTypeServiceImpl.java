package com.patterns.service.impl;

import com.patterns.database.model.type.TypeExercise;
//import com.patterns.database.repository.type.ExerciseTypeRepository;
import com.patterns.database.model.type.TypeMuscle;
import com.patterns.database.repository.type.ExerciseTypeRepository;
import com.patterns.database.repository.type.MuscleTypeRepository;
import com.patterns.dto.mapper.type.TypeExerciseMapper;
import com.patterns.dto.type.TypeExerciseDTO;
import com.patterns.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseTypeServiceImpl implements ExerciseTypeService {
    private final ExerciseTypeRepository repository;
    private final MuscleTypeRepository muscleTypeRepository;
    private final TypeExerciseMapper mapper;

    @Override
    public List<TypeExerciseDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TypeExerciseDTO findByNameToDTO(String name) {
        return repository.findByName(name).map(mapper::convertToDTO).orElseThrow();

    }

    @Override
    public TypeExercise findByName(String name) {
        return repository.findByName(name).orElseThrow();

    }

    @Override
    public Long add(String name, String muscle) {
        TypeExercise typeExercise = new TypeExercise();
        typeExercise.setName(name);
        typeExercise.setTargetMuscle(muscleTypeRepository.findByName(muscle).orElseThrow());
        return repository.save(typeExercise).getId();
    }
}
