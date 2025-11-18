package com.nexdew.studentManagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enrollment {

    @Id
    private Long enrollmentId;
    private LocalDate enrollmentDate;


    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Students student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Courses course;


}




