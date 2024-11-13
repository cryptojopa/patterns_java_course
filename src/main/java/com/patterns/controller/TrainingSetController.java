package com.patterns.controller;


import com.patterns.database.model.TrainingSet;
import com.patterns.service.TrainingSetService;
import com.patterns.task17.AndExpression;
import com.patterns.task17.Expression;
import com.patterns.task17.RepsExpression;
import com.patterns.task17.WeightExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* Client */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training-set")
public class TrainingSetController {
    private final TrainingSetService service;

    @GetMapping("/filter")
    public List<TrainingSet> filterTrainingPlans(
            @RequestParam(required = false) Integer minReps,
            @RequestParam(required = false) Double weight) {
        List<TrainingSet> allPlans = service.findAll();
        List<Expression> expressions = new ArrayList<>();
        if (minReps != null) {
            expressions.add(new RepsExpression(minReps));
        }
        if (weight != null) {
            expressions.add(new WeightExpression(weight));
        }
        Expression finalExpression = buildCompositeExpression(expressions);
        return allPlans.stream()
                .filter(plan -> finalExpression == null || finalExpression.interpret(plan))
                .collect(Collectors.toList());
    }

    private Expression buildCompositeExpression(List<Expression> expressions) {
        if (expressions.isEmpty()) {
            return null;
        }
        Expression result = expressions.get(0);
        for (int i = 1; i < expressions.size(); i++) {
            result = new AndExpression(result, expressions.get(i));
        }
        return result;
    }
}
