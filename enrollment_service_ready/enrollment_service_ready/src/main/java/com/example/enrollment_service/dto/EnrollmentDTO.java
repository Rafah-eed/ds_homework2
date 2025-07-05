package com.example.enrollment_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnrollmentDTO {
    private Long id;
    private Long userId;
    private Long courseId;
}