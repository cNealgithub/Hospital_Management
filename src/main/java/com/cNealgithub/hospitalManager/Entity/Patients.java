package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private int age;
    private String gender;
    private String bloodGroup;
    @OneToOne(cascade = {CascadeType.MERGE ,CascadeType.PERSIST})//owning side
    private Insurance insurance;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;
    @Override
    public String toString() {
        return "patients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
