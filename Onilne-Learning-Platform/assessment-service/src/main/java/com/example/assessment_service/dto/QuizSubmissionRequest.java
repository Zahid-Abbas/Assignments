package com.example.assessment_service.dto;

import java.util.Map;

/** answers: map of questionId -> selectedOption (e.g., {"1":"B","2":"D"}) */
public class QuizSubmissionRequest {
    private String studentName;
    private Map<Long, String> answers;

    public QuizSubmissionRequest() {}

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public Map<Long, String> getAnswers() { return answers; }
    public void setAnswers(Map<Long, String> answers) { this.answers = answers; }
}
