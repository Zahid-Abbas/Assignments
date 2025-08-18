package com.example.classroom_service.service;

import java.util.List;
import com.example.classroom_service.entity.Attendance;

public interface AttendanceService {
    Attendance markAttendance(Long classroomId, Attendance attendance);
    List<Attendance> getAllAttendance();
}
