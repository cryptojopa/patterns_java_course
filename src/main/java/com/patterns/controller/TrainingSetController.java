package com.patterns.controller;

//import com.patterns.database.model.TrainingSet;

import com.patterns.service.TrainingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training-set")
public class TrainingSetController {
    private final TrainingSetService service;

}
