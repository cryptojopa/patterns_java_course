package com.patterns.controller;

import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.type.ExerciseCutDTO;
import com.patterns.service.TrainingPlanService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/training-plans")
@RequiredArgsConstructor
public class TrainingPlanController {
    private final TrainingPlanService service;

    @PostMapping()
    public ResponseEntity<Long> add(@RequestParam("title") @NotBlank String title,
                                      @RequestParam("goal") @NotBlank String goal) {
        return new ResponseEntity<>(service.create(title, goal), HttpStatus.CREATED);
    }

    @GetMapping("/{planId}")
    public ResponseEntity<?> findById(@PathVariable("planId") Long id) {
        return ResponseEntity.ok(service.findById(id)) ;
    }

    @GetMapping()
    public ResponseEntity<List<TrainingPlanCutDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<String> delete(@PathVariable("planId") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }

    @PatchMapping("/{planId}")
    public ResponseEntity<TrainingPlanCutDTO> update(@PathVariable("planId")  Long id,
                                              @QueryParam("title") String title,
                                              @QueryParam("goal") String goal) {
            return new ResponseEntity<>(service.update(id, title, goal), HttpStatus.OK);
    }

    @PostMapping("/{planId}/exercises")
    public Long addExercise(@PathVariable("planId") @NotNull Long id,
                            @RequestParam("exerciseType") String exerciseType) {
            return service.addExercise(id, exerciseType);
    }


    @GetMapping("/{planId}/exercises")
    public List<ExerciseCutDTO> findExercisesByPlanId(@PathVariable("planId") Long id) {
        return service.findExercisesByPlanId(id);
    }
}
