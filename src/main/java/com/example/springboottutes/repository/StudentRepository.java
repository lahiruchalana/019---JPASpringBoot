package com.example.springboottutes.repository;

import com.example.springboottutes.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentByEmailId(String emailId);

    // JPQL
    @Query("select s from Student s where s.firstName = ?1")
    Student getStudentByName(String name);

    List<Student> getStudentByLastNameContaining(String lastName);

    // JPA Query
    @Query("select s.emailId from Student s where s.firstName = ?1")        // return the email of student -> s.emailId
    String getStudentEmailIdByName(String name);           // when name provides the email will return

    // Native Query
    @Query(
            value = "SELECT * FROM student_tbl s where s.first_name = ?1",
            nativeQuery = true
    )
    List<Student> getStudentByNameNative(String name);

    // Native Query with multiple params (using Names Params)
    @Query(
            value = "SELECT * FROM student_tbl s where s.first_name = :name",
            nativeQuery = true
    )
    List<Student> getStudentByNameNativeNamedParam(
            @Param("name") String name      // can use for multiple params
            // @Param("email") String email   // such like examples
    );

    @Modifying
    @Query(
            value = "update student_tbl set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String name, String email);

}
