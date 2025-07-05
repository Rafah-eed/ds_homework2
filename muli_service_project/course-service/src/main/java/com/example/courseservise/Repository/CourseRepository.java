package com.example.courseservise.Repository;

import com.example.courseservise.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByApprovedTrue(); // لإرجاع الكورسات المعتمدة فقط
}
