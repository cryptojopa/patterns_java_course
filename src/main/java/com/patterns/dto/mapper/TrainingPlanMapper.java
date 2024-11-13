package com.patterns.dto.mapper;

import com.patterns.database.model.TrainingPlan;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ExerciseMapper.class)
public interface TrainingPlanMapper {
    @Mapping(source = "trainingPlan.goalType.name", target = "goalType")
    @Mapping(source = "trainingPlan.exercises", target = "exercises")
    TrainingPlanDTO convertToDTO(TrainingPlan trainingPlan);

    @Mapping(source = "trainingPlan.goalType.name", target = "goalType")
    TrainingPlanCutDTO convertToCutDTO(TrainingPlan trainingPlan);
}
