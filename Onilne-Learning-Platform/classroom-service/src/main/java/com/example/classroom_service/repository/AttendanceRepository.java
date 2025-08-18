package com.example.classroom_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.classroom_service.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
