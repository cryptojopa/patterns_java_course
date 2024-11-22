package com.patterns.controller;

import com.patterns.database.model.type.TypeGoal;
import com.patterns.service.GoalTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/goal-types")
@RequiredArgsConstructor
public class GoalTypeController {
    private final GoalTypeService service;

    @GetMapping()
    public List<TypeGoal> findAll() {
        return service.findAll();
    }
}