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

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public List<Student> getStudentsByLastNameContaining(String name) {
        return studentRepository.getStudentByLastNameContaining(name);
    }

    public String getStudentEmailIdByName(String name) {
        return studentRepository.getStudentEmailIdByName(name);
    }

    public List<Student> getStudentByNameNative(String name) {
        return studentRepository.getStudentByNameNative(name);
    }

    public List<Student> getStudentByNameNativeNamedParam(String name) {
        return studentRepository.getStudentByNameNativeNamedParam(name);
    }
}
