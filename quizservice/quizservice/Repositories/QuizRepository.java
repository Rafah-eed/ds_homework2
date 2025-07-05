package com.example.quizservice.Repositories;

import com.example.quizservice.Entities.Question;
import com.example.quizservice.Entities.Quiz;
import com.example.quizservice.Entities.QuizSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findByCourseId(Long courseId);
}

