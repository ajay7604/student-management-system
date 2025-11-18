package com.nexdew.studentManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Students {

    @Id
    private Long studentId;

    private String name;
    private String email;
    private String department;

    @OneToMany(mappedBy = "students",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Address> addresses;

    @PrePersist
    @PreUpdate
    private void setChildrenRelation() {
        if (addresses != null) {
            addresses.forEach(a -> a.setStudents(this));
        }
    }

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

}


