package com.example.assessment_service.service.imp;

import com.example.assessment_service.dto.AssignmentSubmissionRequest;
import com.example.assessment_service.entity.Assignment;
import com.example.assessment_service.entity.Submission;
import com.example.assessment_service.exception.ResourceNotFoundException;
import com.example.assessment_service.repository.AssignmentRepository;
import com.example.assessment_service.repository.SubmissionRepository;
import com.example.assessment_service.service.AssignmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentServiceImp implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final SubmissionRepository submissionRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AssignmentServiceImp(AssignmentRepository assignmentRepository,
                                 SubmissionRepository submissionRepository) {
        this.assignmentRepository = assignmentRepository;
        this.submissionRepository = submissionRepository;
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment getAssignment(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id " + id));
    }

    @Override
    public Submission submitAssignment(Long assignmentId, AssignmentSubmissionRequest request) {
        Assignment assignment = getAssignment(assignmentId);
        try {
            Submission submission = new Submission();
            submission.setType("ASSIGNMENT");
            submission.setReferenceId(assignment.getId());
            submission.setStudentName(request.getStudentName());
            submission.setPayloadJson(objectMapper.writeValueAsString(request));
            submission.setScore(null);              // manual grading later
            submission.setGradedAt(null);
            return submissionRepository.save(submission);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store assignment submission", e);
        }
    }
}
