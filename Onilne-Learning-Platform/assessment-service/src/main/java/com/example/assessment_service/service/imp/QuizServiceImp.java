package com.example.assessment_service.service.imp;

import com.example.assessment_service.dto.QuizSubmissionRequest;
import com.example.assessment_service.entity.Question;
import com.example.assessment_service.entity.Quiz;
import com.example.assessment_service.entity.Submission;
import com.example.assessment_service.exception.ResourceNotFoundException;
import com.example.assessment_service.repository.QuestionRepository;
import com.example.assessment_service.repository.QuizRepository;
import com.example.assessment_service.repository.SubmissionRepository;
import com.example.assessment_service.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class QuizServiceImp implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final SubmissionRepository submissionRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public QuizServiceImp(QuizRepository quizRepository,
                           QuestionRepository questionRepository,
                           SubmissionRepository submissionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.submissionRepository = submissionRepository;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Question addQuestion(Long quizId, Question question) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + quizId));
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
    }

    @Override
    public Submission submitQuiz(Long quizId, QuizSubmissionRequest request) {
        Quiz quiz = getQuiz(quizId);
        List<Question> questions = questionRepository.findByQuizId(quizId);

        Map<Long, String> answers = request.getAnswers();
        int correct = 0;

        for (Question q : questions) {
            String selected = answers != null ? answers.get(q.getId()) : null;
            if (selected != null && selected.equalsIgnoreCase(q.getCorrectOption())) {
                correct++;
            }
        }

        int score = questions.isEmpty() ? 0 : (int) Math.round((correct * 100.0) / questions.size());

        try {
            Submission submission = new Submission();
            submission.setType("QUIZ");
            submission.setReferenceId(quizId);
            submission.setStudentName(request.getStudentName());
            submission.setPayloadJson(objectMapper.writeValueAsString(answers));
            submission.setScore(score);
            submission.setGradedAt(LocalDateTime.now());
            return submissionRepository.save(submission);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store submission", e);
        }
    }
}
