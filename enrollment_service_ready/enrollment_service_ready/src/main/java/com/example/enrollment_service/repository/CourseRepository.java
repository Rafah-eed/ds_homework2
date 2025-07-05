package com.example.enrollment_service.repository;

import com.example.enrollment_service.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}