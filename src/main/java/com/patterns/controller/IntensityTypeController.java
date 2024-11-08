package com.patterns.controller;

import com.patterns.database.model.type.IntensityType;
import com.patterns.service.IntensityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/intensity-types")
@RequiredArgsConstructor
public class IntensityTypeController {
    private final IntensityTypeService service;

    @GetMapping("/get-all")
    public List<IntensityType> getAll() {
        return service.findAll();
    }

//    @PostMapping("/add")
//    public void add(@RequestParam("intensity_type") String intensityType) {
//        service.add(intensityType);
//    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
