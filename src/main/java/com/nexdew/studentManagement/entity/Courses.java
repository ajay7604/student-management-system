package com.nexdew.studentManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Courses {

    @Id
    private Long courseId;

    private String title;
    private String code;
    private int credits;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjects;



    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;



}
