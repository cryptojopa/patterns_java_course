package com.patterns.database.model.type;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "type_muscle", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
@Getter
@Setter

public class TypeMuscle extends Type{
//    @Id
//    @SequenceGenerator(name = "intensity_type_id_seq", sequenceName = "intensity_type_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intensity_type_id_seq")
//    private Long id;

//    @NotBlank
//    @Column(nullable = false, unique = true)
//    private String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TypeMuscle that = (TypeMuscle) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
