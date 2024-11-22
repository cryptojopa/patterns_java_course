package com.patterns.dto.mapper;

import com.patterns.database.model.Exercise;
import com.patterns.dto.ExerciseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TrainingSetMapper.class)
public interface ExerciseMapper {
//    @Mapping(source = "exercise.plan.title", target = "plan")
    @Mapping(source = "exercise.exerciseType.name", target = "exerciseType")
    @Mapping(source = "exercise.exerciseType.targetMuscle.name", target = "targetMuscle")
    ExerciseDTO convertToDTO(Exercise exercise);
}
