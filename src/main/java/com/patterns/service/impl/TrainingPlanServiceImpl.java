package com.patterns.service.impl;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.type.TypeExercise;
import com.patterns.database.model.type.TypeGoal;
import com.patterns.database.repository.TrainingPlanRepository;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.dto.mapper.TrainingPlanMapper;
import com.patterns.service.ExerciseService;
import com.patterns.service.ExerciseTypeService;
import com.patterns.service.GoalTypeService;
import com.patterns.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
    private final TrainingPlanRepository repository;
    private final TrainingPlanMapper mapper;
    private final GoalTypeService goalTypeService;
    private final ExerciseService exerciseService;
    private final ExerciseTypeService exerciseTypeService;

    @Override
    public void create(String title, String goalType) throws NotFoundException {
        TrainingPlan plan = new TrainingPlan();
        plan.setTitle(title);
        plan.setGoal(goalTypeService.findByName(goalType));
        repository.save(plan);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TrainingPlanCutDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToCutDTO).toList();
    }

    @Override
    public void updateTitle(Long id, String title) throws NotFoundException {
        Optional<TrainingPlan> optPlan = repository.findById(id);
        if (optPlan.isPresent()) {
            TrainingPlan plan = optPlan.get();
            plan.setTitle(title);
            repository.save(plan);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void updateGoalType(Long id, String goalType) throws NotFoundException {
        Optional<TrainingPlan> optPlan = repository.findById(id);
        if (optPlan.isPresent()) {
            TrainingPlan plan = optPlan.get();
            plan.setGoal(goalTypeService.findByName(goalType));
            repository.save(plan);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public TrainingPlanDTO findById(Long id) throws NotFoundException {
        return repository.findById(id).map(mapper::convertToDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ExerciseDTO> findExercisesByPlanId(Long id){
        return exerciseService.findByTrainingPlanId(id);
    }

    @Override
    public void addExercise(Long planId, String exerciseType) throws NotFoundException {
        Optional<TrainingPlan> plan = repository.findById(planId);
        if (plan.isPresent()) {
            TypeExercise typeExercise1 = exerciseTypeService.findByName(exerciseType);
            exerciseService.create(plan.get(), typeExercise1);
        }
    }
}
