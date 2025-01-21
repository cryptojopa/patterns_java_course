package com.patterns.controller;

import com.patterns.dto.type.TypeExerciseDTO;
import com.patterns.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exercise-types")
@RequiredArgsConstructor
public class ExerciseTypeController {
    private final ExerciseTypeService service;

    @GetMapping()
    public List<TypeExerciseDTO> findAll() {
        return service.findAll();
    }

    @PostMapping()
    public Long add(@RequestParam("exerciseType") String exerciseType,
                    @RequestParam("targetMuscle") String muscle) {
            return service.add(exerciseType, muscle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
