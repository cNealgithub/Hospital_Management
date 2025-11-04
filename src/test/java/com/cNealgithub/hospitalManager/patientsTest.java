package com.cNealgithub.hospitalManager;

import com.cNealgithub.hospitalManager.Entity.Patients;
import com.cNealgithub.hospitalManager.Repository.patientsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class patientsTest {

    @Autowired
    private patientsRepository patientsRepository;

    @Test
    public void allPatientd() {
        List<Patients> patientsList = patientsRepository.findAll();
        System.out.println(patientsList);
    }

    @Test
    public void findpatient() {
        Patients patient = patientsRepository.findByNameContaining("Akshay");
        System.out.println(patient);
    }

    @Test
    public void patientWithNameAndDateOfBirth() {
        Patients patient = patientsRepository.findByNameAndDateOfBirth("Akshay Kumar", LocalDate.of(2025, 05, 24));
        System.out.println(patient);
    }

    @Test
    public void aLLMales() {
        List<Patients> malePatients = patientsRepository.findByGender("Male");
        for (Patients patient : malePatients) {
            System.out.println(patient);
        }

    }

    @Test
    public void genderCounts() {
        List<Object[]> allGendersCount = patientsRepository.genderCount();
        for (Object[] objects: allGendersCount){
            System.out.println(objects[0] + " " + objects[1]);
        }
    }
}
