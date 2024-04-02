package com.sampleManagement.StudentManagementSys.Service;


import com.sampleManagement.StudentManagementSys.Entity.Student;
import com.sampleManagement.StudentManagementSys.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public Student addStudent(Student student) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
            return studentRepository.save(student);
    }
        public Student getStudentByRollNo(Integer rollNo) {
        Student getstudent= studentRepository.findById(rollNo).orElseThrow(()-> new RuntimeException("Student Details does not exist"));

        return studentRepository.save(getstudent);
    }

        public void deleteStudentDetails(Integer rollNo) {
        studentRepository.findById(rollNo).orElseThrow(()-> new RuntimeException("Student Details does not exist"));
        studentRepository.deleteById(rollNo);
    }
       public List<Student> getAllStudent() {
            return studentRepository.findAll();
        }

//        public Student login(String userName, String password) {
//        return studentRepository.findByUserNameAndPassword(userName,password);
//        }

    public Student updateStudent(Integer rollNo, Student updatestudent) {

        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student details does not exist"));
        if (updatestudent.getStudentName() != null) {
            student.setStudentName(updatestudent.getStudentName());
        }
        if (updatestudent.getEmail() != null) {
            student.setEmail(updatestudent.getEmail());
        }
        if (updatestudent.getUserName() != null) {
            student.setUserName(updatestudent.getUserName());
        }
        if (updatestudent.getPassword() != null) {
            student.setPassword(updatestudent.getPassword());
        }
        return studentRepository.save(student);
    }

}