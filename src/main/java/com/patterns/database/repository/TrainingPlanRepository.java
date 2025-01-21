package com.patterns.database.repository;

import com.patterns.database.model.TrainingPlan;
import com.patterns.database.model.TrainingSet;
import com.patterns.database.model.type.TypeGoal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
    @Modifying
    @Transactional
    @Query("""
            UPDATE TrainingPlan t
                    SET\s
                        t.title = CASE WHEN :title IS NOT NULL THEN :title ELSE t.title END,
                        t.goal = CASE WHEN :goal IS NOT NULL THEN :goal ELSE t.goal END
                    WHERE t.id = :id
            """)
    TrainingPlan update(Long id, String title, TypeGoal goal);
}
