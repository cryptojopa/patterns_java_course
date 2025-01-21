package com.patterns.database.model.type;

import jakarta.persistence.*;

@Entity
@Table(name = "type_muscle", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
public class TypeMuscle extends Type{
}
