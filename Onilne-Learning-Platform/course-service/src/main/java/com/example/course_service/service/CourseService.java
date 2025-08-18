package com.example.course_service.service;

import com.example.course_service.entity.Course;
import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course courseDetails);

    void deleteCourse(Long id);
}
