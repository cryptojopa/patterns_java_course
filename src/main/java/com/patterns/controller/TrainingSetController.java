package com.patterns.controller;

//import com.patterns.database.model.TrainingSet;

import com.patterns.controller.error.NotFoundException;
import com.patterns.service.TrainingSetService;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training-sets")
public class TrainingSetController {
    private final TrainingSetService service;

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") Long id,
                       @QueryParam("weight") Double weight,
                       @QueryParam("reps") Integer reps,
                       @QueryParam("intensity") String intensity,
                       @QueryParam("commentary") String commentary) {
        try {
            service.update(id, weight, reps, intensity, commentary);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
