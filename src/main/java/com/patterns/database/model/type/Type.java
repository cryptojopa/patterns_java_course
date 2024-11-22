package com.patterns.database.model.type;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Type {
    @Id
    @GeneratedValue()
    @Setter(AccessLevel.NONE)
    Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

}
