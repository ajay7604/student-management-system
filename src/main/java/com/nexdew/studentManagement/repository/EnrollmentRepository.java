package com.nexdew.studentManagement.repository;

import com.nexdew.studentManagement.entity.Courses;
import com.nexdew.studentManagement.entity.Enrollment;
import com.nexdew.studentManagement.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("SELECT e.student FROM Enrollment e WHERE e.course.courseId = :courseId")
    List<Students> findStudentsByCourseId(@Param("courseId") Long courseId);


    @Query("SELECT DISTINCT e.course FROM Enrollment e")
    List<Courses> findAllCourse();

    @Query("SELECT e.course FROM Enrollment e WHERE e.student.studentId = :studentId")
    List<Courses> findCourseByStudentId(@Param("studentId") Long studentId);


    Optional<Enrollment> findByStudentStudentId(Long studentId);
}
