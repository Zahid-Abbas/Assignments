package com.example.classroom_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.classroom_service.entity.Attendance;
import com.example.classroom_service.entity.Classroom;
import com.example.classroom_service.exception.AttendanceNotFoundException;
import com.example.classroom_service.repository.AttendanceRepository;
import com.example.classroom_service.repository.ClassroomRepository;
import com.example.classroom_service.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final ClassroomRepository classroomRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, ClassroomRepository classroomRepository) {
        this.attendanceRepository = attendanceRepository;
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Attendance markAttendance(Long classroomId, Attendance attendance) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new AttendanceNotFoundException("Classroom not found with id " + classroomId));

        attendance.setClassroom(classroom);
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}
