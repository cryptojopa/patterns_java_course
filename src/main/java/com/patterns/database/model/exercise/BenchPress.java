package com.patterns.database.model.exercise;

import com.patterns.database.model.Muscle;
import com.patterns.database.model.Set;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class BenchPress extends Exercise{
    public BenchPress() {
        super("Жим штанги лежа", Muscle.CHEST);
    }
    @Override
    public List<Set> getSets() {
        return super.getSets();
    }

    @Override
    public Muscle getTargetMuscle() {
        return super.getTargetMuscle();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void addSet(Set set) {
        super.addSet(set);
    }
}
