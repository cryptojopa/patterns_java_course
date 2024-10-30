package com.patterns.database.model;


import com.patterns.database.model.type.ExerciseType;
import com.patterns.database.model.type.MuscleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
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

    @NotBlank
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "training_plan_id", nullable = false)
    private TrainingPlan plan;

    @OneToMany(mappedBy = "exercise")
    private Set<TrainingSet> trainingSets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "target_muscle_id", nullable = false)
    private MuscleType targetMuscle;

    @ManyToOne
    @JoinColumn(name = "exercise_type_id", nullable = false)
    private ExerciseType exerciseType;

    public Exercise(String title, MuscleType muscleType) {
        this.title = title;
        this.targetMuscle = muscleType;
    }

    public void addSet(TrainingSet trainingSet) {
        trainingSets.add(trainingSet);
    }

    public void removeSet(TrainingSet trainingSet) {
        trainingSets.remove(trainingSet);
    }

//    @Override
//    public String toString() {
//        return "Exercise{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", sets=" + trainingSets +
//                ", targetMuscle=" + targetMuscleType +
//                '}';
//    }
}
