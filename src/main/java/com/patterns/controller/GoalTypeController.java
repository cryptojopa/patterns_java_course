package com.patterns.controller;

import com.patterns.database.model.type.GoalType;
import com.patterns.service.GoalTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/goal-types")
@RequiredArgsConstructor
public class GoalTypeController {
    private final GoalTypeService service;

    @GetMapping("/get-all")
    public List<GoalType> getAll() {
        return service.findAll();
    }

    @PutMapping("/add")
    public void add(@RequestParam("goal_type") String goalType) {
        service.add(goalType);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}