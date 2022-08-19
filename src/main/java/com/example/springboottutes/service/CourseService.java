package com.example.springboottutes.service;

import com.example.springboottutes.entity.Course;
import com.example.springboottutes.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();

        courseRepository.delete(course);
    }
}
