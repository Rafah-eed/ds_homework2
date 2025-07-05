package com.example.quizservice.Controller;

import com.example.quizservice.Entities.Quiz;
import com.example.quizservice.Entities.QuizSubmission;
import com.example.quizservice.Service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }

    @GetMapping("/by-course/{courseId}")
    public ResponseEntity<Quiz> getByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(quizService.getQuizByCourseId(courseId));
    }

    @PostMapping("/submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody QuizSubmission submission) {
        return ResponseEntity.ok(quizService.submitQuiz(submission));
    }
}
