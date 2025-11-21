package com.nexdew.studentManagement.service.impl;

import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Students;
import com.nexdew.studentManagement.entity.Subject;
import com.nexdew.studentManagement.repository.AddressRepository;
import com.nexdew.studentManagement.repository.StudentRepository;
import com.nexdew.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Students> getStudentsByCourseId(Long courseId) {
        return studentRepository.findAll();
    }

    @Override
    public List<Students> createStudent(List<Students> studentsList) {
//
//        for (Students student : studentsList) {
//            if (student.getAddresses() != null) {
//                for (Address address : student.getAddresses()) {
//                    address.setStudents(student);
//                }
//            }
//        }
        return studentRepository.saveAll(studentsList);
    }

    @Override
    public List<Students> getAllstudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students getstudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

    }

    @Override
    public Boolean deleteStudent(Long studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.deleteById(studentId);
        return true;

    }

    @Override
    public Students updateStudent(Long studentId, Students updatedStudent) {
        Students existingStudent = studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("Student not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        return studentRepository.save(existingStudent);

    }


    @Override
    public List<Students> getStudentByAddressId(Long addressId) {
        if(addressId==null){
            throw  new IllegalArgumentException("No Address Found Through this Id :"+addressId);
        }
        return studentRepository.findAllStudentsByAddressId(addressId);
    }

    @Override
    public List<Address> getAddressByStudentId(Long studentId) {
        if (studentId==null){
            throw new RuntimeException("no user found with this specific id:"+studentId);

        }
        return studentRepository.findAllAddressByStudentId(studentId);
    }

    @Override
    public List<Subject> getAllsubjectsByStudentId(Long studentId) {
        if(studentId==null){
            throw  new RuntimeException("no student found by this id:"+studentId);
        }
        return studentRepository.findAllSubjectsByStudentId(studentId);
    }

    @Override
    public Students getAllSubjectsAndCourseByStudentId(Long studentId) {
        if(studentId==null){
            throw  new RuntimeException("no student found by this id:"+studentId);
        }
        return studentRepository.findAllSubjectsAndCourseByStudentId(studentId);
    }

}
