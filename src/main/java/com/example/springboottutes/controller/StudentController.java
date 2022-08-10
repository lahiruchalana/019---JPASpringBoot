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
    public ResponseEntity<?> addNewStudent(
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

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Student> getStudentByName(
            @PathVariable("name") String name
    ){
        return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/lastname/containing/{name}")
    public ResponseEntity<List<Student>> getStudentsByLastNameContaining(
            @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(studentService.getStudentsByLastNameContaining(name), HttpStatus.OK);
    }

    @GetMapping(path = "/emailby/name/{name}")
    public ResponseEntity<String> getStudentEmailIdByName(
            @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(studentService.getStudentEmailIdByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/student/native/{name}")
    public ResponseEntity<List<Student>> getStudentByNameNative(
            @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(studentService.getStudentByNameNative(name), HttpStatus.OK);
    }

    @GetMapping(path = "/student/native/namedparam/{name}")
    public ResponseEntity<List<Student>> getStudentByNameNativeNAmedParam(
            @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(studentService.getStudentByNameNativeNamedParam(name), HttpStatus.OK);
    }

    @PutMapping("update/firstname")
    public ResponseEntity<?> updateFirstNameByEmailId(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String name
    ) {
        studentService.updateFirstNameByEmailId(name, email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
