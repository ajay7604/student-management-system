package com.nexdew.studentManagement.repository;


import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Students;
import com.nexdew.studentManagement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Students, Long> {

    @Query("SELECT DISTINCT s FROM Students s JOIN s.addresses a WHERE a.addressId = :addressId")
    List<Students> findAllStudentsByAddressId(@Param("addressId") Long addressId);


    @Query("SELECT s.addresses FROM Students s WHERE s.studentId = :studentId")
    List<Address> findAllAddressByStudentId(@Param("studentId") Long studentId);

    @Query("""
SELECT DISTINCT sub
FROM Students s
JOIN s.enrollments e
JOIN e.course c
JOIN c.subjects sub
WHERE s.studentId = :studentId
""")
    List<Subject> findAllSubjectsByStudentId(@Param("studentId") Long studentId);


    @Query("""
SELECT DISTINCT s
FROM Students s
LEFT JOIN FETCH s.enrollments e
LEFT JOIN FETCH e.course c
LEFT JOIN FETCH c.subjects sub
WHERE s.studentId = :studentId
""")
    Students findAllSubjectsAndCourseByStudentId(@Param("studentId") Long studentId);
}
