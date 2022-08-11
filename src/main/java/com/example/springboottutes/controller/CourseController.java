package com.example.springboottutes.controller;

import com.example.springboottutes.entity.Course;
import com.example.springboottutes.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCourse(
            @RequestBody Course course
    ) {
        courseService.addNewCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
