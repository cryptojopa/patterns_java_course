package com.patterns.task18;

import com.patterns.database.model.Exercise;
import com.patterns.database.model.type.TypeGoal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//Memento

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingPlanMemento {
    private String title;

    private Set<Exercise> exercises;

    private TypeGoal goal;
}
