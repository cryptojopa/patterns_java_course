package com.patterns.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "set")
@NoArgsConstructor
public class Set {
    @Id
    @SequenceGenerator(name = "set_id_seq", sequenceName = "set_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "set_id_seq")
    @Setter(AccessLevel.NONE)
    private Long id;

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
    private Set(double weight, int reps, Intensity intensity, String commentary) {
        this.weight = weight;
        this.reps = reps;
        this.intensity = intensity;
        this.commentary = commentary != null ? commentary : "";;
    }

    public Set replicate() {
        return new Set(this.weight, this.reps, this.intensity, this.commentary);
    }

    @Override
    public String toString() {
        return "Set" + id +
                "{weight=" + weight +
                ", reps=" + reps +
                ", intensity=" + intensity +
                ", commentary='" + commentary + '\'' +
                '}';
    }
}






