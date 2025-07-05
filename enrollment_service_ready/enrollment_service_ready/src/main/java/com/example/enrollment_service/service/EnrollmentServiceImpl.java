package com.example.enrollment_service.service;

import com.example.enrollment_service.client.UserServiceClient;
import com.example.enrollment_service.dto.EnrollmentDTO;
import com.example.enrollment_service.dto.UserDTO;
import com.example.enrollment_service.model.Course;
import com.example.enrollment_service.model.Enrollment;
import com.example.enrollment_service.repository.CourseRepository;
import com.example.enrollment_service.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements com.example.enrollment_service.service.EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserServiceClient userClient;

    @Override
    public EnrollmentDTO enrollUser(Long courseId, Long userId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        UserDTO userDTO = userClient.getUserById(userId);

        Enrollment enrollment = Enrollment.builder()
                .course(course)
                .userId(userId)
                .build();

        return toDTO(enrollmentRepository.save(enrollment));
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentsByUser(Long userId) {
        return enrollmentRepository.findByUserId(userId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private EnrollmentDTO toDTO(Enrollment enrollment) {
        return EnrollmentDTO.builder()
                .id(enrollment.getId())
                .userId(enrollment.getUserId())
                .courseId(enrollment.getCourse().getId())
                .build();
    }
}