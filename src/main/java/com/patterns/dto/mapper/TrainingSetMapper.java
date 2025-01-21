package com.patterns.dto.mapper;

import com.patterns.database.model.Exercise;
import com.patterns.database.model.TrainingSet;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.dto.mapper.helper.ExerciseMapperHelper;
import com.patterns.dto.mapper.helper.IntensityTypeMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IntensityTypeMapperHelper.class})
public interface TrainingSetMapper {
    @Mapping(source = "trainingSet.exercise.exerciseType.name", target = "exercise")
    @Mapping(source = "trainingSet.intensity.name", target = "intensity")
    TrainingSetDTO convertToDTO(TrainingSet trainingSet);

    @Mapping(source = "trainingSetDTO.intensity", target = "intensity", qualifiedByName = "mapIntensity")
    @Mapping(source = "exercise", target = "exercise")
    TrainingSet convertToEntity(TrainingSetDTO trainingSetDTO, Exercise exercise);
}
