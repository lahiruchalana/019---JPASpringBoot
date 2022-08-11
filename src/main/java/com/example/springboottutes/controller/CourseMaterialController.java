package com.example.springboottutes.controller;

import com.example.springboottutes.entity.CourseMaterial;
import com.example.springboottutes.service.CourseMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
