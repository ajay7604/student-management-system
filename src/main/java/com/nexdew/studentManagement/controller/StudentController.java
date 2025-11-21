package com.nexdew.studentManagement.controller;

import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Students;
import com.nexdew.studentManagement.entity.Subject;
import com.nexdew.studentManagement.service.AddressService;
import com.nexdew.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<List<Students>> createStudent(@RequestBody List<Students> student) {

        List<Students> students = studentService.createStudent(student);
        return ResponseEntity.ok(students);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = studentService.getAllstudents();
        return ResponseEntity.ok(students);

    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Students> getStudentById(@PathVariable Long studentId) {
        Students students= studentService.getstudentById(studentId);
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Students> updateStudent(@PathVariable  Long studentId, @RequestBody Students updatedStudent) {
        return ResponseEntity.ok(studentService.updateStudent(studentId, updatedStudent));
    }

    @GetMapping("/{studentId}/address")
    public ResponseEntity<List<Address>> getAddressByStudentId(@PathVariable Long studentId){
       List<Address> address = studentService.getAddressByStudentId(studentId);
        return  ResponseEntity.ok(address);
    }

    @GetMapping("/{addressId}/student")
    public ResponseEntity<List<Students>> getStudentByAddressId(@PathVariable Long addressId) {
        List<Students> students = studentService.getStudentByAddressId(addressId);
        return ResponseEntity.ok(students);
    }

    @GetMapping("{studentId}/subjects")
    public ResponseEntity<List<Subject>> getSubjectsByStudentId(@PathVariable Long studentId){
       List<Subject> subjects= studentService.getAllsubjectsByStudentId(studentId);
       return ResponseEntity.ok(subjects);
    }

    @GetMapping("{studentId}/course-subjects")
    public ResponseEntity<Students> getSubjectAndCourseByStudentId(@PathVariable Long studentId){
        Students students = studentService.getAllSubjectsAndCourseByStudentId(studentId);
        return ResponseEntity.ok(students);
    }


}

