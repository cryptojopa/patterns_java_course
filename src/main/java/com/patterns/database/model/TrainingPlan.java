package com.patterns.database.model;


import com.patterns.database.model.exercise.Exercise;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*Паттерн Prototype
* Паттерн SFM*/

@Entity
@Getter
@Setter
@Table(name = "training_plan")
public class TrainingPlan {
    @Id
    @Setter(AccessLevel.NONE)
    @SequenceGenerator(name = "training_plan_id_seq", sequenceName = "training_plan_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_plan_id_seq")
    private Long id;

    @OneToMany(mappedBy = "training_plan")
    private List<Exercise> exerciseList;

    private Goal goal;

    public TrainingPlan() {
    }

    private TrainingPlan(List<Exercise> exerciseList, Goal goal) {
    }

    public TrainingPlan replicate() {
        return new TrainingPlan(this.exerciseList, this.goal);
    }
}
