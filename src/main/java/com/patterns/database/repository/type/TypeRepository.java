package com.patterns.database.repository.type;

import com.patterns.database.model.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface TypeRepository<T extends Type> extends JpaRepository<T, Long> {
    Optional<T> findByName(String name);
}
