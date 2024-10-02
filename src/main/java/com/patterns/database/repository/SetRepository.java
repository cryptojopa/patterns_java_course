package com.patterns.database.repository;

import com.patterns.database.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set, Long> {

}
