package com.patterns.controller;

import com.patterns.controller.error.NotFoundException;
import com.patterns.database.model.TrainingPlan;
import com.patterns.dto.ExerciseDTO;
import com.patterns.dto.TrainingPlanCutDTO;
import com.patterns.dto.TrainingPlanDTO;
import com.patterns.service.TrainingPlanService;
import com.patterns.task18.HistoryManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/training-plans")
@RequiredArgsConstructor
public class TrainingPlanController {
    private final TrainingPlanService service;
    private final Map<Long, HistoryManager> historyManagers = new HashMap<>();

    @PostMapping()
    public ResponseEntity<String> add(@RequestParam("title") @NotBlank String title,
                                      @RequestParam("goal") @NotBlank String goalType) {
        try {
            service.create(title, goalType);
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Invalid goal type", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{planId}")
    public ResponseEntity<?> findById(@PathVariable("planId") Long id) {
        try {
            return ResponseEntity.ok(service.findById(id)) ;
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
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

    @PatchMapping("/{planId}/title")
    public ResponseEntity<String> updateTitle(@PathVariable("planId")  Long id,
                                              @RequestParam("title") @NotBlank String title) {
        try {
            service.updateTitle(id, title);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id: " + id);
        }
    }

    @PatchMapping("/{planId}/goal")
    public ResponseEntity<?> updateGoalType(@PathVariable("planId") @NotNull Long id,
                                              @RequestParam("goal") String goalType) {
        try {
            service.updateGoalType(id, goalType);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid plan id: " + id);
        }
    }

    @PostMapping("/{planId}/exercises")
    public void addExercise(@PathVariable("planId") @NotNull Long id,
                            @RequestParam("exerciseType") String exerciseType) {
        try {
            service.addExercise(id, exerciseType);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/{planId}/exercises")
    public List<ExerciseDTO> findExercisesByPlanId(@PathVariable("planId") @NotNull Long id) {
        try {
            return service.findExercisesByPlanId(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/save")
    public ResponseEntity<String> saveState(@PathVariable Long id) {
        TrainingPlan workoutPlan = null;
        try {
            workoutPlan = service.findById(id);
            historyManagers.putIfAbsent(id, new HistoryManager());
            historyManagers.get(id).saveState(workoutPlan.saveToMemento());
            return ResponseEntity.ok("Workout plan saved!");
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/undo")
    public ResponseEntity<String> undo(@PathVariable Long id) {
        TrainingPlan workoutPlan = null;
        try {
            workoutPlan = service.findById(id);
            HistoryManager historyManager = historyManagers.get(id);

            if (workoutPlan == null || historyManager == null || !historyManager.hasHistory()) {
                return ResponseEntity.badRequest().body("No previous state to restore!");
            }

            workoutPlan.restoreFromMemento(historyManager.getPreviousState());
            return ResponseEntity.ok("Workout plan restored to previous state!");
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
