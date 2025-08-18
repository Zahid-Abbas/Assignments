package com.example.assessment_service.service;

import com.example.assessment_service.dto.AssignmentSubmissionRequest;
import com.example.assessment_service.entity.Assignment;
import com.example.assessment_service.entity.Submission;

import java.util.List;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    Assignment getAssignment(Long id);
    Submission submitAssignment(Long assignmentId, AssignmentSubmissionRequest request);
}
