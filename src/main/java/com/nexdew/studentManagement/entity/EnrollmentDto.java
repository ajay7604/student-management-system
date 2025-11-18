package com.nexdew.studentManagement.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentDto {
    private Long enrollmentId;
    private LocalDate enrollmentDate;
    private Long studentId;
    private Long courseId;
}