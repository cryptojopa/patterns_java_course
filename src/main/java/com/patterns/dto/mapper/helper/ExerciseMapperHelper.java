package com.patterns.dto.mapper.helper;

import com.patterns.database.model.Exercise;
import com.patterns.database.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExerciseMapperHelper {
    private final ExerciseRepository repository;

    @Named("mapExercise")
    public Exercise map(String name) {
        return repository.findByExerciseTypeName(name);
    }
}
