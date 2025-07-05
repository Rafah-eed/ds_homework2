package com.example.courseservise.service.Impl;

import com.example.courseservise.Repository.CourseRepository;
import com.example.courseservise.dto.CourseDTO;
import com.example.courseservise.entity.Course;
import com.example.courseservise.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseDTO createCourse(CourseDTO dto) {
        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .instructor(dto.getInstructor())
                .capacity(dto.getCapacity())
                .build();
        return toDTO(courseRepository.save(course));
    }
    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findByApprovedTrue()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructor(dto.getInstructor());
        course.setCapacity(dto.getCapacity());
        return toDTO(courseRepository.save(course));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    private CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .instructor(course.getInstructor())
                .capacity(course.getCapacity())
                .build();
    }

    @Override
    public CourseDTO approveCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setApproved(true);
        return toDTO(courseRepository.save(course));
    }

}
