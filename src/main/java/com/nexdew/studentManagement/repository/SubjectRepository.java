package com.nexdew.studentManagement.repository;

import com.nexdew.studentManagement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
