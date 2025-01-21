package com.patterns.database.model.type;

import com.patterns.dto.type.TypeExerciseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.function.Function;

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

    public TypeExerciseDTO map(Function<TypeExercise, TypeExerciseDTO> mapper) {
        return mapper.apply(this);
    }
}