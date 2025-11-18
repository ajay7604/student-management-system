package com.nexdew.studentManagement.repository;

import com.nexdew.studentManagement.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Courses, Long> {
    @Query("SELECT c FROM Courses c LEFT JOIN FETCH c.subjects WHERE c.courseId = :courseId")
    Optional<Courses> findByCourseIdWithSubjets(Long courseId);
}
