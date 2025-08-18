package com.example.classroom_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.classroom_service.entity.Attendance;
import com.example.classroom_service.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/{classroomId}")
    public ResponseEntity<Attendance> markAttendance(@PathVariable Long classroomId, @RequestBody Attendance attendance) {
        return ResponseEntity.ok(attendanceService.markAttendance(classroomId, attendance));
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }
}
