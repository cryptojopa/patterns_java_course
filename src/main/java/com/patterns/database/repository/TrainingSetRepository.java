package com.patterns.database.repository;

import com.patterns.database.model.TrainingSet;
import com.patterns.database.model.type.TypeIntensity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingSetRepository extends JpaRepository<TrainingSet, Long> {
    List<TrainingSet> findByExerciseId(Long exerciseId);

    @Modifying
    @Transactional
    @Query("""
            UPDATE TrainingSet t
                    SET\s
                        t.weight = CASE WHEN :weight IS NOT NULL THEN :weight ELSE t.weight END,
                        t.reps = CASE WHEN :reps IS NOT NULL THEN :reps ELSE t.reps END,
                        t.intensity = CASE WHEN :intensity IS NOT NULL THEN :intensity ELSE t.intensity END,
                        t.commentary = CASE WHEN :commentary IS NOT NULL THEN :commentary ELSE t.commentary END
                    WHERE t.id = :id
            """)
    void update(
            @Param("id") Long id,
            @Param("weight") Double weight,
            @Param("reps") Integer reps,
            @Param("intensity") TypeIntensity intensity,
            @Param("commentary") String commentary
    );
}
