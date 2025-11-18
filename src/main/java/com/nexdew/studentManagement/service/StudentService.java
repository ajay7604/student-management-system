package com.nexdew.studentManagement.service;


import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Students;
import com.nexdew.studentManagement.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Students> getStudentsByCourseId(Long courseId);

    List<Students> createStudent(List<Students> student);

    List<Students> getAllstudents();

    Students getstudentById(Long studentId);

    Boolean deleteStudent(Long studentId);

    Students updateStudent(Long studentId, Students updatedStudent);


   
    

    List<Students> getStudentByAddressId(Long addressId);

    List<Address> getAddressByStudentId(Long studentId);



    List<Subject> getAllsubjectsByStudentId(Long studentId);

    Students getAllSubjectsAndCourseByStudentId(Long studentId);
}
