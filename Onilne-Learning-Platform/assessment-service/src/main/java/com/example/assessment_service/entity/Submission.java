package com.example.assessment_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** QUIZ or ASSIGNMENT */
    @Column(nullable=false)
    private String type;

    /** quizId or assignmentId */
    @Column(nullable=false)
    private Long referenceId;

    @Column(nullable=false)
    private String studentName;

    /** For quiz: answers JSON (e.g. {"1":"A","2":"C"}) ; For assignment: text/url */
    @Lob
    private String payloadJson;

    /** Auto-graded for quizzes, nullable for assignments */
    private Integer score;

    private LocalDateTime gradedAt;

    public Submission() {}

    public Submission(Long id, String type, Long referenceId, String studentName,
                      String payloadJson, Integer score, LocalDateTime gradedAt) {
        this.id = id;
        this.type = type;
        this.referenceId = referenceId;
        this.studentName = studentName;
        this.payloadJson = payloadJson;
        this.score = score;
        this.gradedAt = gradedAt;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Long getReferenceId() { return referenceId; }
    public void setReferenceId(Long referenceId) { this.referenceId = referenceId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getPayloadJson() { return payloadJson; }
    public void setPayloadJson(String payloadJson) { this.payloadJson = payloadJson; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public LocalDateTime getGradedAt() { return gradedAt; }
    public void setGradedAt(LocalDateTime gradedAt) { this.gradedAt = gradedAt; }
}
