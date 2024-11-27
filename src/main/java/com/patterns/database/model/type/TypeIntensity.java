package com.patterns.database.model.type;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_intensity", uniqueConstraints= @UniqueConstraint(columnNames={"name"}) )
public class TypeIntensity extends Type{
}
