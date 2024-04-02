package com.sampleManagement.StudentManagementSys.Service;

import com.sampleManagement.StudentManagementSys.Entity.Exam;

import com.sampleManagement.StudentManagementSys.Repository.ExamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam updateExam(int examId, Exam updateexam){

        Exam exam = examRepository.findById(examId).orElseThrow(()-> new RuntimeException("Exam ID not found"));

        if(updateexam.getExamName()!=null){
            exam.setExamName(updateexam.getExamName());

        }
        return examRepository.save(exam);
    }


    public List<Exam> getAllExams(){
        return examRepository.findAll();
    }


    public void deleteExam(int examId) {
        examRepository.findById(examId).orElseThrow(() -> new RuntimeException("exam Id not found"));
        examRepository.deleteById(examId);
    }
}


