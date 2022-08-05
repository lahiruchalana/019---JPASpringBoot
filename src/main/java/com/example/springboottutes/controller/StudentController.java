package com.example.springboottutes.controller;

import com.example.springboottutes.entity.Student;
import com.example.springboottutes.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/student" )
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addNewStudent(
            @RequestBody Student student
    ) {
        studentService.addNewStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<Student> getStudentByEmailId(
            @PathVariable("email") String email
    ) {
        return new ResponseEntity<>(studentService.getStudentByEmailId(email), HttpStatus.OK);
    }

}
