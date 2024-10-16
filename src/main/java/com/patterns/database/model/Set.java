package com.patterns.database.model;

import com.patterns.database.model.exercise.Exercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/* Реализует паттерн Builder*/
@Entity
@Getter
@Setter
@Table(name = "exercise_set")
@NoArgsConstructor
public class Set {
    @Id
    @SequenceGenerator(name = "set_id_seq", sequenceName = "set_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "set_id_seq")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exercise_set_id")
    private Exercise exercise;

    @Column(name = "weight")
    private double weight;

    @NotNull
    @Column
    private int reps;

    @NotNull
    @Column(name = "intensity")
    private Intensity intensity;

    @Size(max = 50)
    @NotNull
    private String commentary;

    @Builder
    private Set(Exercise exercise, double weight, int reps, Intensity intensity, String commentary) {
        this.exercise = exercise; //надо что-то с ошибкой сделать;
        this.weight = weight;
        this.reps = reps;
        this.intensity = intensity;
        this.commentary = commentary != null ? commentary : "";
    }

    public Set replicate() {
        return new Set(this.exercise, this.weight, this.reps, this.intensity, this.commentary);
    }

    @Override
    public String toString() {
        return "Set" +
                "{weight=" + weight +
                ", reps=" + reps +
                ", intensity=" + intensity +
                ", commentary='" + commentary + '\'' +
                '}';
    }
}






