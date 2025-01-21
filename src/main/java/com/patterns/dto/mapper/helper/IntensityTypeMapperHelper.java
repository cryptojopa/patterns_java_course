package com.patterns.dto.mapper.helper;

import com.patterns.database.model.type.TypeIntensity;
import com.patterns.database.repository.type.IntensityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntensityTypeMapperHelper {
    private final IntensityTypeRepository repository;

    @Named("mapIntensity")
    public TypeIntensity map(String value) {
        return repository.findByName(value).orElseThrow();
    }
}
