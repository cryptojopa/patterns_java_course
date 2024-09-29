package com.patterns.database.model.exercise;


import com.patterns.database.model.Muscle;
import com.patterns.database.model.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Exercise {
    @Id
    @SequenceGenerator(name = "exercise_id_seq", sequenceName = "exercise_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "sets")
    private List<Set> sets = new ArrayList<>();

    @NotBlank
    @Column(name = "target_muscle")
    private Muscle targetMuscle;

    Exercise(String title, Muscle muscle) {
        this.title = title;
        this.targetMuscle = muscle;
    }

    public void addSet(Set set) {
        sets.add(set);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sets=" + sets +
                ", targetMuscle=" + targetMuscle +
                '}';
    }
}
