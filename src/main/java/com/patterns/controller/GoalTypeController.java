package com.patterns.controller;

import com.patterns.dto.type.TypeGoalDTO;
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
    public List<TypeGoalDTO> findAll() {
        return service.findAll();
    }
}