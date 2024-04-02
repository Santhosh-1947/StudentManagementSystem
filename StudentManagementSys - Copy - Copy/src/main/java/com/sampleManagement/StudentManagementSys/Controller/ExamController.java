package com.sampleManagement.StudentManagementSys.Controller;
import com.sampleManagement.StudentManagementSys.Entity.Exam;
import com.sampleManagement.StudentManagementSys.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Exam createdExam = examService.createExam(exam);
        return new ResponseEntity<Exam>(createdExam, HttpStatus.CREATED);
    }

    @PutMapping("/{examId}")
    public ResponseEntity<Exam> updateExam(@PathVariable int examId, @RequestBody Exam updateexam){

        Exam updatedExam = examService.updateExam(examId, updateexam);

        return ResponseEntity.ok(updatedExam);
    }


    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(@PathVariable int examId){
            examService.deleteExam(examId);
        return ResponseEntity.ok("Exam Deleted");

    }

    @GetMapping
    public ResponseEntity <List<Exam>> getAllExams(){

        List<Exam> exams=examService.getAllExams();
     return ResponseEntity.ok(exams);
    }
}

