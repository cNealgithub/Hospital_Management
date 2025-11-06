package com.cNealgithub.hospitalManager.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder//helps to easily instantiate new objects
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 50)
    private String policyNumber;
    @Column(nullable = false, length = 40)
    private String provider;
    @Column(nullable = false)
    private LocalDate validUntil;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;
    @OneToOne(mappedBy = "insurance")//inverse side
    private Patients patient;
}
