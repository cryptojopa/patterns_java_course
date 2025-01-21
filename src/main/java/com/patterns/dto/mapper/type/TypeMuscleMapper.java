package com.patterns.dto.mapper.type;

import com.patterns.database.model.type.TypeMuscle;
import com.patterns.dto.type.TypeMuscleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMuscleMapper {
    TypeMuscleDTO convertToDTO(TypeMuscle typeMuscle);
}
