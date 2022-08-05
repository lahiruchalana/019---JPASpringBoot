package com.example.springboottutes.repository;

import com.example.springboottutes.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentByEmailId(String emailId);

    // JPQL
    @Query("select s from Student s where s.firstName = ?1")
    Student getStudentByName(String name);

    List<Student> getStudentByLastNameContaining(String lastName);

    @Query("select s.emailId from Student s where s.firstName = ?1")        // return the email of student -> s.emailId
    String getStudentEmailIdByName(String name);           // when name provides the email will return
}
