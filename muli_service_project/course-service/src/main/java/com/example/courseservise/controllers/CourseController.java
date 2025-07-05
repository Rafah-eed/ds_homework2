package com.example.courseservise.controllers;

import com.example.courseservise.dto.CourseDTO;
import com.example.courseservise.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService  courseService;
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.createCourse(courseDTO));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO dto) {
        return ResponseEntity.ok(courseService.updateCourse(id, dto));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/approve")
    public ResponseEntity<CourseDTO> approveCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.approveCourse(id));
    }



}
