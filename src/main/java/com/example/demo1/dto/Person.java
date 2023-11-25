package com.example.demo1.dto;


import lombok.Data;

@Data
public class Person {
    private String name;
    private String passportID;
    private String nationality;
    private Location location;
}
