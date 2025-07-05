package com.example.quizservice.Service;

import com.example.quizservice.Entities.Question;
import com.example.quizservice.Entities.Quiz;
import com.example.quizservice.Entities.QuizSubmission;
import com.example.quizservice.Repositories.QuizRepository;
import com.example.quizservice.Repositories.QuizSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepo;
    private final QuizSubmissionRepository submissionRepo;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public Quiz getQuizByCourseId(Long courseId) {
        return quizRepo.findByCourseId(courseId).orElseThrow();
    }

    public int submitQuiz(QuizSubmission submission) {
        Quiz quiz = quizRepo.findById(submission.getQuizId()).orElseThrow();
        List<Question> questions = quiz.getQuestions();
        List<Integer> answers = submission.getAnswers();

        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i) == questions.get(i).getCorrectAnswerIndex()) {
                score++;
            }
        }

        submission.setScore(score);
        submissionRepo.save(submission);
        return score;
    }
}
