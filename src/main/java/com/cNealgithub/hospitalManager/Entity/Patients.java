package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)//owning side
    private Insurance insurance;
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE} ,orphanRemoval = true,fetch = FetchType.EAGER) //if patient is deleted all appointments to this atient will be deleted.
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", insurance=" + insurance +
                ", appointments=" + appointments +
                '}';
    }
}
