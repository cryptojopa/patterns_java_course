package com.patterns.database.model.type;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "type_exercise", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeExercise extends Type{
    @ManyToOne
    @JoinColumn(name = "target_muscle_id", nullable = false)
    private TypeMuscle targetMuscle;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TypeExercise that = (TypeExercise) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}