package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceId;
    @Column(nullable = false, unique = true, length = 50)
    private String policyNumber;
    @Column(nullable = false, length = 40)
    private String provider;
    @Column(nullable = false)
    private LocalDate validUntil;
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;
}
