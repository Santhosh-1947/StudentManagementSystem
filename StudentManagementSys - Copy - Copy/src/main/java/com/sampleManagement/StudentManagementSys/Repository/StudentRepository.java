package com.sampleManagement.StudentManagementSys.Repository;

import com.sampleManagement.StudentManagementSys.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUserNameAndPassword(String username, String password);


    Optional<Student> findByUserName(String username);
}
