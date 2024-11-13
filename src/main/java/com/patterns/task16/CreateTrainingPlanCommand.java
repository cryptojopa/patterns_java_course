package com.patterns.task16;

import com.patterns.controller.error.InvalidDataException;
import com.patterns.database.model.TrainingPlan;
import com.patterns.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


/* Реализация конкретной комманды */

@Component
@RequiredArgsConstructor
public class CreateTrainingPlanCommand implements Command<TrainingPlan>{
    private final TrainingPlanService service;
    private final String title;
    private final String goalType;


    @Override
    public TrainingPlan execute() {
        try {
            service.create(title, goalType);
            return service.findByTitle(title);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }
}
