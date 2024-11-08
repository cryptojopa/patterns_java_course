package com.patterns.database.model;

import com.patterns.database.model.type.IntensityType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "training_set")
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSet {
    @Id
    @SequenceGenerator(name = "training_id_seq", sequenceName = "training_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_id_seq")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_set_id", nullable = false)
    private Exercise exercise;

    @Column(name = "weight")
    private double weight;

    @NotNull
    @Column(name = "reps")
    private int reps;

    @ManyToOne
    @JoinColumn(name = "intensity_type_id", nullable = false)
    private IntensityType intensity;

    @Size(max = 50)
    @NotNull
    private String commentary;

    @Builder
    private TrainingSet(Exercise exercise, double weight, int reps, IntensityType intensity, String commentary) {
        this.exercise = exercise; //надо что-то с ошибкой сделать;
        this.weight = weight;
        this.reps = reps;
        this.intensity = intensity;
        this.commentary = commentary != null ? commentary : "";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TrainingSet that = (TrainingSet) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}






