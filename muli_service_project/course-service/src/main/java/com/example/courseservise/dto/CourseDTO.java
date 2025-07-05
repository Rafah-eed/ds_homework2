package com.example.courseservise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String instructor;
    private int capacity;
    private boolean approved; // تمت الإضافة لتتبع الموافقة
}
