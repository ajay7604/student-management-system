package com.nexdew.studentManagement.service;

import com.nexdew.studentManagement.entity.Courses;

import java.util.List;

public interface CourseService {
    Courses getCourseById(Long courseId);

    Courses createCourse(Courses courses);

    Courses updateCourse(Long courseId, Courses updatedCourse);

    Boolean deleteCourse(Long courseId);

    List<Courses> getAllCourses();
}
