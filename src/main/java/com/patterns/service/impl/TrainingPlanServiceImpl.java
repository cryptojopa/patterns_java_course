package com.patterns.service.impl;

import com.patterns.controller.error.InvalidDataException;
import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.TrainingPlan;
import com.patterns.database.repository.TrainingPlanRepository;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.dto.mapper.TrainingPlanMapper;
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

    @Override
    public void create(String title, String goalType) throws InvalidDataException {
        TrainingPlan plan = new TrainingPlan();
        plan.setTitle(title);
        plan.setGoalType(goalTypeService.findByName(goalType));
        repository.save(plan);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TrainingPlanDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
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
    public void updateGoalType(Long id, String goalType) throws NotFoundException, InvalidDataException {
        Optional<TrainingPlan> optPlan = repository.findById(id);
        if (optPlan.isPresent()) {
            TrainingPlan plan = optPlan.get();
            plan.setGoalType(goalTypeService.findByName(goalType));
            repository.save(plan);
        } else {
            throw new NotFoundException();
        }
    }
}
