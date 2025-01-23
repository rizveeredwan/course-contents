package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // repository for data access
public interface StudentRepository extends JpaRepository<Student,Long>{
  
    // Select * from student where email = ? 
    @Query("SELECT s from Student s where s.email=?1")
    Optional<Student> findStudentByEmail(String email); 
} 