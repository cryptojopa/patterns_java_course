package com.patterns.controller;

import com.patterns.database.model.TrainingPlan;
import com.patterns.service.TrainingPlanService;
import com.patterns.task16.CommandInvoker;
import com.patterns.task16.CreateTrainingPlanCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/* Client */
@RestController
@RequestMapping("api/training-plan")
@RequiredArgsConstructor
public class TrainingPlanController {
    private final TrainingPlanService service;
    private final CommandInvoker invoker;
    @PostMapping("/add")
    public TrainingPlan add(@RequestParam("title") @NotBlank String title,
                            @RequestParam("goal_type") @NotBlank String goalType) {
        return invoker.executeCommand(new CreateTrainingPlanCommand(service, title, goalType));
    }
}
