package com.patterns.dto.mapper;

import com.patterns.database.model.Exercise;
import com.patterns.dto.ExerciseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    @Mapping(source = "exercise.plan.title", target = "plan")
    @Mapping(source = "exercise.targetMuscle.name", target = "targetMuscle")
    @Mapping(source = "exercise.exerciseType.name", target = "exerciseType")
    ExerciseDTO convertToDTO(Exercise exercise);
}
