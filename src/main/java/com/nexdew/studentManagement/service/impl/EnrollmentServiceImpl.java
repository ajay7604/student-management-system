package com.nexdew.studentManagement.service.impl;


import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Enrollment;
import com.nexdew.studentManagement.entity.EnrollmentDto;
import com.nexdew.studentManagement.repository.CourseRepository;
import com.nexdew.studentManagement.repository.EnrollmentRepository;
import com.nexdew.studentManagement.repository.StudentRepository;
import com.nexdew.studentManagement.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.nexdew.studentManagement.entity.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl  implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;





    @Override
    public List<Students> getStudentsByCourseId(Long courseId) {

        List<Students> studentsByCourseId = enrollmentRepository.findStudentsByCourseId(courseId);
        // if(studentsByCourseId==null){
        if(studentsByCourseId.isEmpty()){

            throw new RuntimeException("No students found for the given course ID: " + courseId);
        }
        return studentsByCourseId;

    }


    //when we have to create single single enrollments.....
//    @Override
//    public Enrollment createEnrollment(EnrollmentDto enrollmentDto) {
//        Students student = studentRepository.findById(enrollmentDto.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found by Id"));
//        Courses course = courseRepository.findById(enrollmentDto.getCourseId()).orElseThrow(() -> new IllegalArgumentException("Course not found by Id"));
//        Enrollment e = new Enrollment();
//            e.setEnrollmentId(enrollmentDto.getEnrollmentId());
//            e.setEnrollmentDate(enrollmentDto.getEnrollmentDate());
//            e.setStudent(student);
//            e.setCourse(course);
//
//        return enrollmentRepository.save(e);
//    }

    @Override
    public List<Enrollment> createEnrollment(List<EnrollmentDto> enrollmentDtoList) {
        List<Enrollment> enrollments = new ArrayList<>();

        for (EnrollmentDto dto : enrollmentDtoList) {
            Students student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            Courses course = courseRepository.findById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            Enrollment e = new Enrollment();
            e.setEnrollmentId(dto.getEnrollmentId());
            e.setEnrollmentDate(dto.getEnrollmentDate());
            e.setStudent(student);
            e.setCourse(course);

            enrollments.add(e);
        }
        return enrollmentRepository.saveAll(enrollments);
    }

    @Override
    public List<Enrollment>  getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Courses> getAllCourses() {
        return enrollmentRepository.findAllCourse();
    }



    @Override
    public List<Courses> getAllCoursess(Long studentId) {

        List<Courses> courseByStudentId = enrollmentRepository.findCourseByStudentId(studentId);
        if(courseByStudentId==null){
            throw new RuntimeException("no student found for this courseid:" +studentId);
        }
        return courseByStudentId;
    }


    @Override
    public String cancel(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Not Found: " + enrollmentId));
        enrollmentRepository.delete(enrollment);
        return "Enrollment Delete By Id: "+enrollmentId;
    }

    @Override
    public String cancle(Long studentId) {
        Enrollment enrollment = enrollmentRepository.findByStudentStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("student not found:" + studentId));
        enrollmentRepository.delete(enrollment);
        return "Enrollment Cancel By StudentId "+studentId;

    }

    @Override
    public String cancleEnroll(Long courseID) {
        Enrollment enrollment = enrollmentRepository.findByCourseCourseID(courseID)
                .orElseThrow(() -> new RuntimeException("student not found:" + courseID));
        enrollmentRepository.delete(enrollment);
        return "Enrollment Cancel By StudentId "+courseID;

    }

}






