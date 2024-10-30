package com.patterns.database.repository.type;

import com.patterns.database.model.type.MuscleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleTypeRepository extends JpaRepository<MuscleType, Long> {
    Optional<MuscleType> findByName(String name);
}
