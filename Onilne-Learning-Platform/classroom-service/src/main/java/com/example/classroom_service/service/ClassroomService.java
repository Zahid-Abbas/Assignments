package com.example.classroom_service.service;

import com.example.classroom_service.entity.Classroom;
import java.util.List;

public interface ClassroomService {
    Classroom createClassroom(Classroom classroom);
    List<Classroom> getAllClassrooms();
    Classroom getClassroomById(Long id);
    Classroom updateClassroom(Long id, Classroom classroomDetails);
    void deleteClassroom(Long id);
}
