package com.patterns.controller;

import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ExerciseDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/{exerciseId}/sets")
    public Long addSet(@PathVariable("exerciseId") Long id,
                       @RequestBody TrainingSetDTO trainingSetDTO){
        return service.addSet(id, trainingSetDTO);
    }

    @GetMapping("/{exerciseId}/sets")
    public List<TrainingSetDTO> findSetsByExerciseId(@PathVariable("exerciseId") Long id) {
        return service.findByExerciseId(id);
    }
}