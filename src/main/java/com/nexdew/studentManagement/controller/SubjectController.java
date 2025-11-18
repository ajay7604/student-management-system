package com.nexdew.studentManagement.controller;


import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Subject;
import com.nexdew.studentManagement.service.AddressService;
import com.nexdew.studentManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<List<Subject>> createSubject(@RequestBody List<Subject> subjects) {
        List<Subject> createdSubject = subjectService.createSubject(subjects);
        return ResponseEntity.ok(createdSubject);
    }
}
