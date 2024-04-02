package com.sampleManagement.StudentManagementSys.Service;


import com.sampleManagement.StudentManagementSys.Entity.Mark;
import com.sampleManagement.StudentManagementSys.Entity.Student;
import com.sampleManagement.StudentManagementSys.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    public List<Mark> getMarksByStudent(int rollNo) {
        Student student = markRepository.findById(rollNo).orElseThrow(()-> new RuntimeException("Student Mark Details does not exist")).getStudent();
        return markRepository.findByStudent(student);
    }

    public Mark addMarks(Mark mark) {
        mark.setTotalMark(mark.getTamil() + mark.getEnglish() + mark.getMaths() + mark.getScience() + mark.getSocialScience());
        mark.setAverageMark(mark.getTotalMark() / 5.0);
        return markRepository.save(mark);
    }

    public Mark updateMark(Integer rollNo, Mark updatemark){
        Mark mark = markRepository.findById(rollNo).orElseThrow(()->new RuntimeException("Requested RollNo not found"));

        if(updatemark.getTamil()!=0){
            mark.setTamil(updatemark.getTamil());
        }
        if(updatemark.getEnglish()!=0){
        mark.setEnglish(updatemark.getEnglish());
        }
        if(updatemark.getMaths()!=0){
        mark.setMaths(updatemark.getMaths());
        }
        if(updatemark.getScience()!=0){
        mark.setScience(updatemark.getScience());
        }
        if(updatemark.getSocialScience()!=0){
        mark.setSocialScience(updatemark.getSocialScience());
        }

        return markRepository.save(mark);
    }

    public void deleteStudentRecord(int rollNo){
        markRepository.findById(rollNo).orElseThrow(()-> new RuntimeException("Student Details does not exist"));
        markRepository.deleteById(rollNo);
    }

}
