package com.nexdew.studentManagement.service.impl;

import com.nexdew.studentManagement.entity.Subject;
import com.nexdew.studentManagement.repository.StudentRepository;
import com.nexdew.studentManagement.repository.SubjectRepository;
import com.nexdew.studentManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private  SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Subject createSubject(Subject subjects) {
        return subjectRepository.save(subjects);
    }
}
