package com.patterns.task16;

import com.patterns.controller.error.InvalidDataException;
import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.TrainingPlan;
import com.patterns.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


/* Реализация конкретной комманды */

@Component
@RequiredArgsConstructor
public class UpdateTrainingPlanCommand implements Command<TrainingPlan>{
    private final TrainingPlanService service;
    private final String title;
    private final String goalType;
    private final Long id;

    @Override
    public TrainingPlan execute() {
        try {
            service.updateTitle(this.id, title);
            service.updateGoalType(this.id, goalType);
            return service.findByTitle(title);
        } catch (NotFoundException | InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }
}
