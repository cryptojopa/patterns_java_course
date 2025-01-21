package com.patterns.controller;

import com.patterns.database.model.type.TypeMuscle;
import com.patterns.dto.type.TypeMuscleDTO;
import com.patterns.service.MuscleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/muscle-types")
@RequiredArgsConstructor
public class MuscleTypeController {
    private final MuscleTypeService service;

    @GetMapping()
    public List<TypeMuscleDTO> findAll() {
        return service.findAll();
    }
}
