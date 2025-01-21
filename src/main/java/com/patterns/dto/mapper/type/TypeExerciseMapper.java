package com.patterns.dto.mapper.type;

import com.patterns.database.model.type.TypeExercise;
import com.patterns.dto.type.TypeExerciseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypeExerciseMapper {
    @Mapping(source = "exerciseType.targetMuscle.name", target = "targetMuscle")
    TypeExerciseDTO convertToDTO(TypeExercise exerciseType);
}
