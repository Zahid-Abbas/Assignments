package com.example.assessment_service.service;

import com.example.assessment_service.dto.QuizSubmissionRequest;
import com.example.assessment_service.entity.Question;
import com.example.assessment_service.entity.Quiz;
import com.example.assessment_service.entity.Submission;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    Question addQuestion(Long quizId, Question question);
    List<Quiz> getAllQuizzes();
    Quiz getQuiz(Long id);
    Submission submitQuiz(Long quizId, QuizSubmissionRequest request);
}
