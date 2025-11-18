package com.nexdew.studentManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    private long addressId;
    private String address;
    private String location;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Students students;

}
