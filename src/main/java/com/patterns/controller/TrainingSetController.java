package com.patterns.controller;

//import com.patterns.database.model.TrainingSet;

import com.patterns.dto.TrainingSetDTO;
import com.patterns.service.TrainingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training-set")
public class TrainingSetController {
    @Autowired
    private final TrainingSetService service;

    @GetMapping("/exercise/{exerciseId}")
    public List<TrainingSetDTO> getTrainingSetsByExerciseId(@PathVariable long exerciseId) {
        return service.getTrainingSetsByExerciseId(exerciseId);
    }
}
