package com.patterns.dto.mapper;

import com.patterns.database.model.TrainingSet;
import com.patterns.dto.TrainingSetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingSetMapper {
    @Mapping(source = "trainingSet.exercise.exerciseType.name", target = "exercise")
    @Mapping(source = "trainingSet.intensity.name", target = "intensity")
    TrainingSetDTO convertToDTO(TrainingSet trainingSet);
}
