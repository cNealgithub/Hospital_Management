package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalDateTime appointmentTime;
    @Column(nullable = false)
    private String reason;
    @ManyToOne
    private Patients patient;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
