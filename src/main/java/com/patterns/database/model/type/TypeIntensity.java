package com.patterns.database.model.type;

import jakarta.persistence.*;

@Entity
@Table(name = "type_intensity", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
public class TypeIntensity extends Type{
}
