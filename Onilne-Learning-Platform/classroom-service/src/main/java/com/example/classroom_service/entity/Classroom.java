package com.example.classroom_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId;   // Reference to course in Course Service
    private String teacherName;
    private LocalDateTime scheduleTime;
    private int totalStudents;
    private String meetingUrl;

    public Classroom() {}

    public Classroom(Long id, Long courseId, String teacherName, LocalDateTime scheduleTime, int totalStudents, String meetingUrl) {
        this.id = id;
        this.courseId = courseId;
        this.teacherName = teacherName;
        this.scheduleTime = scheduleTime;
        this.totalStudents = totalStudents;
        this.meetingUrl = meetingUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getMeetingUrl() {
        return meetingUrl;
    }

    public void setMeetingUrl(String meetingUrl) {
        this.meetingUrl = meetingUrl;
    }
}
