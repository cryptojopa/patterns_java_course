package com.patterns.service.impl;

import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.type.TypeExercise;
import com.patterns.database.repository.TrainingPlanRepository;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.dto.mapper.TrainingPlanMapper;
import com.patterns.dto.type.ExerciseCutDTO;
import com.patterns.service.ExerciseService;
import com.patterns.service.ExerciseTypeService;
import com.patterns.service.GoalTypeService;
import com.patterns.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
    private final TrainingPlanRepository repository;
    private final TrainingPlanMapper mapper;
    private final GoalTypeService goalTypeService;
    private final ExerciseService exerciseService;
    private final ExerciseTypeService exerciseTypeService;

    @Override
    public Long create(String title, String goalType) {
        TrainingPlan plan = new TrainingPlan();
        plan.setTitle(title);
        plan.setGoal(goalTypeService.findByName(goalType));
        return repository.save(plan).getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TrainingPlanCutDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToCutDTO).toList();
    }

    @Override
    public TrainingPlanDTO findById(Long id)   {
        return repository.findById(id).map(mapper::convertToDTO)
                .orElseGet(() -> mapper.convertToDTO(new TrainingPlan()));
    }

    @Override
    public List<ExerciseCutDTO> findExercisesByPlanId(Long id){
        return exerciseService.findByTrainingPlanId(id);
    }

    @Override
    public Long addExercise(Long planId, String exerciseType)   {
        TrainingPlan plan = repository.findById(planId).get();
        TypeExercise typeExercise = exerciseTypeService.findByName(exerciseType);
        return exerciseService.create(plan, typeExercise);
    }

    @Override
    public TrainingPlanCutDTO update(Long id, String title, String goal) {
        return mapper.convertToCutDTO(repository.update(id, title, goalTypeService.findByName(goal)));
    }
}
