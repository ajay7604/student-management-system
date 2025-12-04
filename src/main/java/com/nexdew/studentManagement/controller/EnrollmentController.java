package com.nexdew.studentManagement.controller;


import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Enrollment;
import com.nexdew.studentManagement.entity.EnrollmentDto;
import com.nexdew.studentManagement.service.EnrollmentService;
import com.nexdew.studentManagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nexdew.studentManagement.entity.Students;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final StudentService studentService;

    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<Students>> getStudentsByCourseId(@PathVariable Long courseId) {
        List<Students> students = enrollmentService.getStudentsByCourseId(courseId);
        return ResponseEntity.ok(students);
    }

//    @PostMapping("/enrollment")
//    public ResponseEntity<List<Enrollment>> createEnrollment(@RequestBody List<EnrollmentDto> enrollmentDtoList) {
//        List<Enrollment> enrollments = enrollmentService.createEnrollment(enrollmentDtoList);
//        return ResponseEntity.ok(enrollments);
//    }

    @PostMapping("/enrollment")
    public ResponseEntity<List<Enrollment>> createEnrollment(@RequestBody List<EnrollmentDto> enrollmentDtoList){
        return ResponseEntity.ok( enrollmentService.createEnrollment(enrollmentDtoList));
    }

    @GetMapping("/enrollment")
    public ResponseEntity<List<Enrollment> > getAllEnrollment() {
        List<Enrollment> allEnrollment = enrollmentService.getAllEnrollment();
        return ResponseEntity.ok(allEnrollment);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Courses> > getAllCourses() {
        List<Courses> course = enrollmentService.getAllCourses();
        return ResponseEntity.ok(course);
    }


    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Courses>> getCourseByStudentId(@PathVariable Long studentId) {
        List<Courses> courses = enrollmentService.getAllCoursess(studentId);
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping("studentId/{studentId}")
    public ResponseEntity<String> cancleByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(enrollmentService.cancle(studentId));
    }


    @DeleteMapping("enrollmentId/{enrollmentId}")
    public ResponseEntity<String> cancelByEnrollmentId(@PathVariable Long enrollmentId){
        return ResponseEntity.ok(enrollmentService.cancel(enrollmentId));
    }

    @DeleteMapping("courseID/{courseID}")
    public ResponseEntity<String> cancleEnroll(@PathVariable Long courseID){
        return ResponseEntity.ok(enrollmentService.cancleEnroll(courseID));
    }

}



