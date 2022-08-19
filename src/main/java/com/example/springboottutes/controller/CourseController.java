package com.example.springboottutes.controller;

import com.example.springboottutes.entity.Course;
import com.example.springboottutes.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewCourse(
            @RequestBody Course course
    ) {
        courseService.addNewCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{courseId}")
    public ResponseEntity<?> deleteCourseById(
            @PathVariable("courseId") Long courseId
    ) {
        courseService.deleteCourseById(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
