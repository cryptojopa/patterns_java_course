package com.patterns.service.impl;

import com.patterns.database.model.type.TypeExercise;
//import com.patterns.database.repository.type.ExerciseTypeRepository;
import com.patterns.database.model.type.TypeMuscle;
import com.patterns.database.repository.type.ExerciseTypeRepository;
import com.patterns.database.repository.type.MuscleTypeRepository;
import com.patterns.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseTypeServiceImpl implements ExerciseTypeService {
    private final ExerciseTypeRepository repository;
    private final MuscleTypeRepository muscleTypeRepository;

    @Override
    public List<TypeExercise> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TypeExercise findByName(String name){
        return repository.findByName(name).orElseGet(TypeExercise::new);

    }

    @Override
    public void add(String name, String muscle){
        if (repository.findByName(name).isEmpty()) {
            TypeExercise typeExercise = new TypeExercise();
            typeExercise.setName(name);
            typeExercise.setTargetMuscle(muscleTypeRepository.findByName(muscle).orElseGet(TypeMuscle::new));
            repository.save(typeExercise);
        }
    }
}
