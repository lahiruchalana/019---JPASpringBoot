package com.example.springboottutes.service;

import com.example.springboottutes.entity.Student;
import com.example.springboottutes.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentByEmailId(String email) {
        return studentRepository.getStudentByEmailId(email);
    }
}
