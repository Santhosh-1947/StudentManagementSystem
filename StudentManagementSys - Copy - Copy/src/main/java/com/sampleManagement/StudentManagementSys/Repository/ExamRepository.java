package com.sampleManagement.StudentManagementSys.Repository;

import com.sampleManagement.StudentManagementSys.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
