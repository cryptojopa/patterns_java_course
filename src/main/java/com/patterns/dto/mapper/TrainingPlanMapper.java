package com.patterns.dto.mapper;

import com.patterns.database.model.TrainingPlan;
import com.patterns.dto.TrainingPlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingPlanMapper {
    @Mapping(source = "trainingPlan.goalType.name", target = "goalType")
    TrainingPlanDTO convertToDTO(TrainingPlan trainingPlan);
}
