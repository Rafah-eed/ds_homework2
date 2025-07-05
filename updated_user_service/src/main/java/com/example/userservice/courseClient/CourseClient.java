package com.example.userservice.courseClient;

import com.example.userservice.DTOs.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "courseServise", path = "/api/courses")
public interface CourseClient {

    @GetMapping("/instructor/{id}")
    List<CourseDTO> getCoursesForInstructor(@PathVariable Long id);

}

