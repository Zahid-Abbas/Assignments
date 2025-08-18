package com.example.classroom_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.classroom_service.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
