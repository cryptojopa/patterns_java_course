package com.patterns.database.model.type;

import lombok.*;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "type_goal", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
@Getter
@Setter
public class TypeGoal extends Type {
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TypeGoal typeGoal = (TypeGoal) object;
        return Objects.equals(id, typeGoal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
