package com.patterns.database.model.exercise.eng;

import com.patterns.database.model.exercise.Exercise;
import com.patterns.database.model.MuscleType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BarbellSquatsEng extends Exercise {

    public BarbellSquatsEng() {
        super("Barbell Squats", MuscleType.LEGS);
    }
}
