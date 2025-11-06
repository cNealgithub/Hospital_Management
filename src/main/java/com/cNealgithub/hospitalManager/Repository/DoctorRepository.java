package com.cNealgithub.hospitalManager.Repository;

import com.cNealgithub.hospitalManager.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}