package com.patterns.controller;

import com.patterns.database.model.type.MuscleType;
import com.patterns.service.MuscleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/muscle-types")
@RequiredArgsConstructor
public class MuscleTypeController {
    private final MuscleTypeService service;

    @GetMapping("/get-all")
    public List<MuscleType> getAll() {
        return service.findAll();
    }

    @PutMapping("/add")
    public void add(@RequestParam("muscle_type") String muscleType) {
        service.add(muscleType);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
