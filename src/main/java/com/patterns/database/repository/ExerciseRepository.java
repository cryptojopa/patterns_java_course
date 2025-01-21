package com.patterns.database.repository;

import com.patterns.database.model.Exercise;
import com.patterns.dto.ExerciseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query("SELECT e FROM Exercise e WHERE e.plan.id = :id")
    List<Exercise> findByTrainingPlanId(Long id);

    @Query("SELECT e FROM Exercise e WHERE e.exerciseType.name = :name")
    Exercise findByExerciseTypeName(String name);
}
