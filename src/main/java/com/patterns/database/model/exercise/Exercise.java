package com.patterns.database.model.exercise;


import com.patterns.database.model.MuscleType;
import com.patterns.database.model.Set;
import com.patterns.database.model.TrainingPlan;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Exercise {
    @Id
    @SequenceGenerator(name = "exercise_id_seq", sequenceName = "exercise_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_id_seq")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_plan_id", nullable = false)
    private TrainingPlan trainingPlan;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "sets")
    @OneToMany(mappedBy = "exercise")
    private List<Set> sets = new ArrayList<>();

    @NotBlank
    @Column(name = "target_muscle")
    private MuscleType targetMuscleType;

    public Exercise(String title, MuscleType muscleType) {
        this.title = title;
        this.targetMuscleType = muscleType;
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
                ", targetMuscle=" + targetMuscleType +
                '}';
    }
}
