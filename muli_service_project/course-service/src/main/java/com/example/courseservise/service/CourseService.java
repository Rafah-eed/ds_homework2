package com.example.courseservise.service;

import com.example.courseservise.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO dto);
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO updateCourse(Long id, CourseDTO dto);
    void deleteCourse(Long id);

    CourseDTO approveCourse(Long id); // جديد
}
