package com.patterns.database.model.exercise;

import com.patterns.database.model.exercise.Exercise;
import com.patterns.database.model.MuscleType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BarbellSquatsRu extends Exercise {
    public BarbellSquatsRu() {
        super("Приседания со штангой", MuscleType.LEGS);
    }
}
