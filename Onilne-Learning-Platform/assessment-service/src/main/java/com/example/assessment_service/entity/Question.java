package com.example.assessment_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    @Column(nullable=false)
    private String text;

    /** Store options as a JSON-like string (e.g. ["A","B","C","D"]) */
    @Lob
    private String optionsJson;

    /** Store correct option key/value (e.g. "B" or "2") */
    @Column(nullable=false)
    private String correctOption;

    public Question() {}

    public Question(Long id, Quiz quiz, String text, String optionsJson, String correctOption) {
        this.id = id;
        this.quiz = quiz;
        this.text = text;
        this.optionsJson = optionsJson;
        this.correctOption = correctOption;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getOptionsJson() { return optionsJson; }
    public void setOptionsJson(String optionsJson) { this.optionsJson = optionsJson; }
    public String getCorrectOption() { return correctOption; }
    public void setCorrectOption(String correctOption) { this.correctOption = correctOption; }
}
