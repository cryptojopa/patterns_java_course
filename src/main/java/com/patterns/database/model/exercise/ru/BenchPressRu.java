package com.patterns.database.model.exercise.ru;

import com.patterns.database.model.exercise.Exercise;
import com.patterns.database.model.MuscleType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BenchPressRu extends Exercise {
    public BenchPressRu() {
        super("Жим штанги лежа", MuscleType.CHEST);
    }
}
