package com.patterns.database.model.exercise.eng;

import com.patterns.database.model.MuscleType;
import com.patterns.database.model.exercise.Exercise;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BenchPressEng extends Exercise {
    public BenchPressEng() {
        super("Bench Press", MuscleType.CHEST);
    }
}
