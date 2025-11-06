package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    private Doctor headDoctor;
    @ManyToMany
    private Set<Doctor> doctors = new HashSet<>();
}
