package com.patterns.controller;

import com.patterns.controller.error.InvalidDataException;
import com.patterns.controller.error.NotFoundException;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.service.TrainingPlanService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/training-plan")
@RequiredArgsConstructor
public class TrainingPlanController {
    private final TrainingPlanService service;
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam("title") @NotBlank String title,
                                      @RequestParam("goal_type") @NotBlank String goalType) {
        try {
            service.create(title, goalType);
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        } catch (InvalidDataException e) {
            return new ResponseEntity<>("Invalid goal type", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TrainingPlanDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}/update/title")
    public ResponseEntity<String> updateTitle(@PathVariable("id")  Long id,
                                              @RequestParam("title") @NotBlank String title) {
        try {
            service.updateTitle(id, title);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id: " + id);
        }
    }

    @PutMapping("/{id}/update/goal")
    public ResponseEntity<String> updateGoalType(@PathVariable("id") Long id,
                                              @RequestParam("goal_type") String goalType) {
        try {
            service.updateGoalType(id, goalType);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id: " + id);
        } catch (InvalidDataException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid goal: " + goalType);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.findById(id)) ;
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
    }

    @GetMapping("/{id}/exercises")
    public List<ExerciseDTO> findExercisesByPlanId(@PathVariable("id") Long id) {
        try {
            return service.findExercisesByPlanId(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
