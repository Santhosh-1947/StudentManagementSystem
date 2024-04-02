package com.sampleManagement.StudentManagementSys.Repository;

import com.sampleManagement.StudentManagementSys.Entity.Mark;
import com.sampleManagement.StudentManagementSys.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

    List<Mark> findByStudent(Student student);



}
