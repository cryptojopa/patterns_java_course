package com.patterns.dto.mapper.type;

import com.patterns.database.model.type.TypeIntensity;
import com.patterns.dto.type.TypeIntensityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeIntensityMapper {
    TypeIntensityDTO convertToDTO(TypeIntensity intensity);
}
