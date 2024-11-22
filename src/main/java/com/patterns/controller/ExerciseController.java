package com.patterns.controller;

import com.patterns.controller.error.NotFoundException;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.dto.TrainingSetDTO;
import com.patterns.service.ExerciseService;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
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
        try {
            return service.findById(id);
        } catch (NotFoundException e) {
            throw new RuntimeException();
        }
    }

    @PostMapping("/{exerciseId}/sets")
    public void addSet(@PathVariable("exerciseId") Long id,
                       @RequestParam("weight") Double weight,
                       @RequestParam("reps") Integer reps,
                       @RequestParam("intensity") String intensity,
                       @RequestParam("commentary") String commentary) {
        try {
            service.addSet(id, weight, reps, intensity, commentary);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{exerciseId}/sets")
    public List<TrainingSetDTO> findSetsByExerciseId(@PathVariable("exerciseId") Long id) {
        return service.findByExerciseId(id);
    }
}