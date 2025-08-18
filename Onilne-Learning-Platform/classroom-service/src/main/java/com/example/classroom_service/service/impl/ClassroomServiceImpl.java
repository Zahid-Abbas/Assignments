package com.example.classroom_service.service.impl;

import com.example.classroom_service.entity.Classroom;
import com.example.classroom_service.exception.ClassroomNotFoundException;
import com.example.classroom_service.repository.ClassroomRepository;
import com.example.classroom_service.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found with id " + id));
    }

    @Override
    public Classroom updateClassroom(Long id, Classroom classroomDetails) {
        Classroom classroom = getClassroomById(id);
        classroom.setCourseId(classroomDetails.getCourseId());
        classroom.setTeacherName(classroomDetails.getTeacherName());
        classroom.setScheduleTime(classroomDetails.getScheduleTime());
        classroom.setTotalStudents(classroomDetails.getTotalStudents());
        classroom.setMeetingUrl(classroomDetails.getMeetingUrl());
        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroom(Long id) {
        Classroom classroom = getClassroomById(id);
        classroomRepository.delete(classroom);
    }
}
