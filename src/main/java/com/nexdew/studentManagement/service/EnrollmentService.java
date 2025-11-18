package com.nexdew.studentManagement.service;

import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Enrollment;
import com.nexdew.studentManagement.entity.EnrollmentDto;
import com.nexdew.studentManagement.entity.Students;

import java.util.List;

public interface EnrollmentService {



    List<Students> getStudentsByCourseId(Long courseId);

    List<Enrollment> createEnrollment(List<EnrollmentDto> enrollmentDtoList);


    List<Enrollment>  getAllEnrollment();

    List<Courses> getAllCourses();


    List<Courses> getAllCoursess(Long studentId);
}
