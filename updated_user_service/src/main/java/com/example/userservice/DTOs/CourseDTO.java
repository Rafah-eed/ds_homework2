package com.example.userservice.DTOs;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String instructor;
    private int capacity;
    private boolean approved; // تمت الإضافة لتتبع الموافقة
}