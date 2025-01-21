package com.patterns.database.model;


import com.patterns.database.model.type.TypeExercise;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.mapper.ExerciseMapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

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
    @Setter(AccessLevel.NONE)
    private TrainingPlan plan;

    @OneToMany(mappedBy = "exercise")
    private Set<TrainingSet> trainingSets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "type_exercise_id", nullable = false)
    @Setter(AccessLevel.NONE)
    private TypeExercise exerciseType;

    public void addSet(TrainingSet trainingSet) {
        trainingSets.add(trainingSet);
    }

    public void removeSet(TrainingSet trainingSet) {
        trainingSets.remove(trainingSet);
    }

    public Exercise(TypeExercise exerciseType, TrainingPlan plan) {
        this.exerciseType = exerciseType;
        this.plan = plan;
    }

    public ExerciseDTO map(Function<Exercise,ExerciseDTO> mapper) {
        return mapper.apply(this);
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
