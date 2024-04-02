package com.sampleManagement.StudentManagementSys.Entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Mark {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne

    private Student student;
    @ManyToOne
    private Exam exam;
    private int tamil;
    private int english;
    private int maths;
    private int science;
    private int socialScience;
    private int totalMark;
    private double averageMark;
}
