package com.patterns.database.model.type;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_goal", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
public class TypeGoal extends Type {
}
