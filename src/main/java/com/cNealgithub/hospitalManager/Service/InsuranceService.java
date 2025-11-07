package com.cNealgithub.hospitalManager.Service;

import com.cNealgithub.hospitalManager.Entity.Insurance;
import com.cNealgithub.hospitalManager.Entity.Patients;

public interface InsuranceService {

    public Patients assignInsuranceToPatient(Insurance insurance, long patientId);
    public Patients disAssociateInsurance(Long patientId);
}
