package com.example.assessment_service.controller;

import com.example.assessment_service.dto.AssignmentSubmissionRequest;
import com.example.assessment_service.entity.Assignment;
import com.example.assessment_service.entity.Submission;
import com.example.assessment_service.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<Assignment> create(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(assignmentService.createAssignment(assignment), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAll() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.getAssignment(id));
    }

    @PostMapping("/{assignmentId}/submit")
    public ResponseEntity<Submission> submit(@PathVariable Long assignmentId,
                                             @RequestBody AssignmentSubmissionRequest request) {
        return ResponseEntity.ok(assignmentService.submitAssignment(assignmentId, request));
    }
}
