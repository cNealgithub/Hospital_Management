package com.cNealgithub.hospitalManager.Repository;

import com.cNealgithub.hospitalManager.Entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface patientsRepository extends JpaRepository<Patients, Long> {
    List<Patients> findByGender(String gender);

    Patients findByNameContaining(String Name);

    @Query("SELECT p FROM Patients p WHERE p.name = :name AND p.dateOfBirth = :dateOfBirth")
    Patients findByNameAndDateOfBirth(@Param("name") String name , @Param("dateOfBirth") LocalDate dateOfBirth);

    @Query("SELECT p.gender, Count(p) FROM Patients p group by p.gender")
    List<Object[]> genderCount();
}
