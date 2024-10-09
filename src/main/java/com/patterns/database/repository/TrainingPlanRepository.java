package com.patterns.database.repository;

import com.patterns.database.model.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
    Optional<TrainingPlan> findById(Long id);


}
