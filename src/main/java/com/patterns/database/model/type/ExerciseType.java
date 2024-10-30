package com.patterns.database.model.type;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "exercise_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseType{
    @Id
    @SequenceGenerator(name = "exercise_type_id_seq", sequenceName = "exercise_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_type_id_seq")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;
}