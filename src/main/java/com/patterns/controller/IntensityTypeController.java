package com.patterns.controller;

import com.patterns.database.model.type.TypeIntensity;
import com.patterns.dto.type.TypeIntensityDTO;
import com.patterns.service.IntensityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/intensity-types")
@RequiredArgsConstructor
public class IntensityTypeController {
    private final IntensityTypeService service;

    @GetMapping()
    public List<TypeIntensityDTO> findAll() {
        return service.findAll();
    }
}
