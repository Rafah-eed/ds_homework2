package com.example.enrollment_service.controller;


import com.example.enrollment_service.dto.EnrollmentDTO;
import com.example.enrollment_service.dto.EnrollmentRequest;
import com.example.enrollment_service.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    // تغيير المسار هنا لتجنب التعارض
    @PostMapping("/by-id")
    public EnrollmentDTO enroll(@RequestParam Long courseId, @RequestParam Long userId) {
        return enrollmentService.enrollUser(courseId, userId);
    }


    @GetMapping("/user/{userId}")
    public List<EnrollmentDTO> getEnrollments(@PathVariable Long userId) {
        return enrollmentService.getEnrollmentsByUser(userId);
    }


    @PostMapping
    public ResponseEntity<String> enrollInCourse(@RequestBody EnrollmentRequest request) {
        // من المفترض أن تبحث في قاعدة البيانات، لكن حالياً فقط للتجربة:
        String message = String.format("تم تسجيل %s بنجاح في دورة %s", request.getUsername(), request.getCourseName());
        return ResponseEntity.ok(message);
    }

}