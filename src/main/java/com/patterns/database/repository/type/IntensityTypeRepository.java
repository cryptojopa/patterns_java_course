package com.patterns.database.repository.type;

import com.patterns.database.model.type.IntensityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntensityTypeRepository extends JpaRepository<IntensityType, Long> {
    Optional<IntensityType> findByName(String name);
}
