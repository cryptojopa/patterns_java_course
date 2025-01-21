package com.patterns.dto.mapper.type;

import com.patterns.database.model.type.TypeGoal;
import com.patterns.dto.type.TypeGoalDTO;
import org.mapstruct.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;

@Mapper(componentModel = "spring")
public interface TypeGoalMapper {
    TypeGoalDTO convertToDTO(TypeGoal goal);
}
