package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String specialization;
    @Column(nullable = false)
    private String email;
    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();
    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();
}
