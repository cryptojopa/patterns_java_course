package com.patterns;

import com.patterns.database.model.Intensity;
import com.patterns.database.model.Set;
import com.patterns.database.model.exercise.Exercise;
import com.patterns.database.model.exercise.ExerciseFactory;
import com.patterns.database.model.exercise.ExerciseType;
import com.patterns.exception.UnknownTypeException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ExerciseFactory factory = new ExerciseFactory();
		Exercise exercise;
		try {
			exercise = factory.createExercise(ExerciseType.BENCH_PRESS);

			Set set = Set.builder()
					.weight(100.0)
					.reps(12)
					.intensity(Intensity.MAX)
					.commentary("Тяжело")
					.build();

			exercise.addSet(set);

			System.out.println(exercise.getSets());
			System.out.println(exercise.getTitle());
			System.out.println(exercise.getTargetMuscle());
		} catch (UnknownTypeException ignored) {

		}

	}
}
