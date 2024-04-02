package com.sampleManagement.StudentManagementSys.Configuration;

import com.sampleManagement.StudentManagementSys.Entity.Student;
import com.sampleManagement.StudentManagementSys.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class StudentUserDetailsService implements UserDetailsService {


    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Student> student = studentRepository.findByUserName(username);
        return student.map(StudentUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
