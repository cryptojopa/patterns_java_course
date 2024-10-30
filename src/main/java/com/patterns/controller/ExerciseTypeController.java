package com.patterns.controller;

import com.patterns.database.model.type.ExerciseType;
import com.patterns.service.ExerciseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exercise-types")
@RequiredArgsConstructor
public class ExerciseTypeController {
    private final ExerciseTypeService service;

    @GetMapping("/get-all")
    public List<ExerciseType> getAll() {
        return service.findAll();
    }

    @PutMapping("/add")
    public void add(@RequestParam("exercise_type") String exerciseType) {
        service.add(exerciseType);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
