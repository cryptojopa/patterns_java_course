package com.patterns.controller;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.type.TypeExercise;
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
    public List<TypeExercise> findAll() {
        return service.findAll();
    }

    @PostMapping()
    public void add(@RequestParam("exerciseType") String exerciseType,
                    @RequestParam("targetMuscle") String muscle) {
        try {
            service.add(exerciseType, muscle);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
