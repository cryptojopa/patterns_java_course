package com.patterns.database.repository;

import com.patterns.database.model.TrainingSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingSetRepository extends JpaRepository<TrainingSet, Long> {
    List<TrainingSet> findByExerciseId(long exerciseId);
}
