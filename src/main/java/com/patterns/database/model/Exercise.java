package com.patterns.database.model;


import com.patterns.database.model.type.TypeExercise;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercise")
public class Exercise {
    @Id
    @SequenceGenerator(name = "exercise_id_seq", sequenceName = "exercise_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_id_seq")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_plan_id", nullable = false)
    private TrainingPlan plan;

    @OneToMany(mappedBy = "exercise")
    private Set<TrainingSet> trainingSets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "exercise_type_id", nullable = false)
    private TypeExercise typeExercise;

    public void addSet(TrainingSet trainingSet) {
        trainingSets.add(trainingSet);
    }

    public void removeSet(TrainingSet trainingSet) {
        trainingSets.remove(trainingSet);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Exercise exercise = (Exercise) object;
        return Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
