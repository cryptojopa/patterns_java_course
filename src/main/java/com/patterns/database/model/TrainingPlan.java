package com.patterns.database.model;


import com.patterns.database.model.type.GoalType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "training_plan")
@AllArgsConstructor
@NoArgsConstructor
public class TrainingPlan {
    @Id
    @Setter(AccessLevel.NONE)
    @SequenceGenerator(name = "training_plan_id_seq", sequenceName = "training_plan_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_plan_id_seq")
    private Long id;

    @OneToMany(mappedBy = "plan")
    private Set<Exercise> exerciseList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "goal_type_id")
    private GoalType goalType;
}
