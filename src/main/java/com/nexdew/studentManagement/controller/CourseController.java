package com.nexdew.studentManagement.controller;

import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Students;
import com.nexdew.studentManagement.service.CourseService;
import com.nexdew.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<Students>> getStudentsByCourse(@PathVariable Long courseId) {
        List<Students> students = studentService.getStudentsByCourseId(courseId);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{courseId}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long courseId) {
        Courses course = courseService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/courses")
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course) {
        Courses courses = courseService.createCourse(course);
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Courses> updateCourse(@PathVariable Long courseId, @RequestBody Courses updatedCourse) {
        Courses course = courseService.updateCourse(courseId, updatedCourse);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
}
