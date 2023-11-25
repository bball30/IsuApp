package com.example.demo1.dto;


import lombok.Data;

@Data
public class StudyGroupBase {
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
    private Long studentsCount;
    private int shouldBeExpelled;
    private String formOfEducation;
    private String semesterEnum;
    private Person groupAdmin;
}
