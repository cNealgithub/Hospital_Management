package com.cNealgithub.hospitalManager.Service.IMPL;

import com.cNealgithub.hospitalManager.Entity.Insurance;
import com.cNealgithub.hospitalManager.Entity.Patients;
import com.cNealgithub.hospitalManager.Repository.InsuranceRepository;
import com.cNealgithub.hospitalManager.Repository.patientsRepository;
import com.cNealgithub.hospitalManager.Service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final patientsRepository patientsRepository;

    @Override
    @Transactional//to make the cascading work in the persistence context.
    public Patients assignInsuranceToPatient(Insurance insurance, long patientId) {
        Patients patient = patientsRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found wih id: " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);//this to maintain bidirectional consistency, yet it will work without this line too.
        return patient;
    }
}
