package com.patterns.database.model;


import com.patterns.database.model.type.GoalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
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

    @Column(unique = true, name = "title")
    @NotBlank
    private String title;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "plan")
    private Set<Exercise> exerciseList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "goal_type_id")
    private GoalType goalType;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TrainingPlan that = (TrainingPlan) object;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
