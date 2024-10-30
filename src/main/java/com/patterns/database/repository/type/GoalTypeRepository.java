package com.patterns.database.repository.type;

import com.patterns.database.model.type.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalTypeRepository extends JpaRepository<GoalType, Long> {
    Optional<GoalType> findByName(String name);
}
