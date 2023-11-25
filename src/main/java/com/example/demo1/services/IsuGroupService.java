package com.example.demo1.services;

import com.example.demo1.dto.CountExpelledDTO;

public interface IsuGroupService {
    CountExpelledDTO countExpelledStudents();

    CountExpelledDTO expelAllStudents(Long groupId);

}
