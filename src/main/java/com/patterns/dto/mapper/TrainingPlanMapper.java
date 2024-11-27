package com.patterns.dto.mapper;

import com.patterns.database.model.TrainingPlan;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ExerciseMapper.class)
public interface TrainingPlanMapper {
    @Mapping(source = "trainingPlan.goal.name", target = "goal")
    @Mapping(source = "trainingPlan.exercises", target = "exercises")
    TrainingPlanDTO convertToDTO(TrainingPlan trainingPlan);

    @Mapping(source = "trainingPlan.goal.name", target = "goal")
    TrainingPlanCutDTO convertToCutDTO(TrainingPlan trainingPlan);
}
