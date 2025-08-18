package com.example.assessment_service.dto;

public class AssignmentSubmissionRequest {
    private String studentName;
    /** Can be plain text, URL to file, etc. */
    private String content;

    public AssignmentSubmissionRequest() {}

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
