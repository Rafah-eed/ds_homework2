package com.example.enrollment_service.service;

import com.example.enrollment_service.dto.EnrollmentDTO;


import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollUser(Long courseId, Long userId);
    List<EnrollmentDTO> getEnrollmentsByUser(Long userId);
}