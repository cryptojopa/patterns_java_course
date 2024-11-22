package com.patterns.database.model.type;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "type_intensity", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
@Getter
@Setter
public class TypeIntensity extends Type{
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TypeIntensity typeIntensity = (TypeIntensity) object;
        return Objects.equals(id, typeIntensity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
