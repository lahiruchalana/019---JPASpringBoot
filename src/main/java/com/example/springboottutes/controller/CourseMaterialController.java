package com.example.springboottutes.controller;

import com.example.springboottutes.entity.CourseMaterial;
import com.example.springboottutes.service.CourseMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/course/material")
public class CourseMaterialController {

    private final CourseMaterialService courseMaterialService;

    public CourseMaterialController(CourseMaterialService courseMaterialService) {
        this.courseMaterialService = courseMaterialService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCourseMaterial(
            @RequestBody CourseMaterial courseMaterial
            ) {
        courseMaterialService.addNewCourseMaterial(courseMaterial);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseMaterial>> getAllCourseMaterials() {
        return new ResponseEntity<>(courseMaterialService.getAllCourseMaterials(), HttpStatus.OK);
    }
}
