package com.patterns.database.model.type;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "intensity_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IntensityType {
    @Id
    @SequenceGenerator(name = "intensity_type_id_seq", sequenceName = "intensity_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intensity_type_id_seq")
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IntensityType intensityType = (IntensityType) object;
        return Objects.equals(id, intensityType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
