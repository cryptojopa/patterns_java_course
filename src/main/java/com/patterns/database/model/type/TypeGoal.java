package com.patterns.database.model.type;

import jakarta.persistence.*;

@Entity
@Table(name = "type_goal", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
public class TypeGoal extends Type {
}
