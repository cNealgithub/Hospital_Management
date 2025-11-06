package com.cNealgithub.hospitalManager.Repository;

import com.cNealgithub.hospitalManager.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}