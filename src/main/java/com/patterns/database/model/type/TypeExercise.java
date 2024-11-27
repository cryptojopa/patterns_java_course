package com.patterns.database.model.type;

import jakarta.persistence.*;
import lombok.*;

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
}