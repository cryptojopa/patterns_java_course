package com.patterns.database.model.type;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "goal_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoalType {
    @Id
    @SequenceGenerator(name = "goal_type_id_seq", sequenceName = "goal_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goal_type_id_seq")
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GoalType goalType = (GoalType) object;
        return Objects.equals(id, goalType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
