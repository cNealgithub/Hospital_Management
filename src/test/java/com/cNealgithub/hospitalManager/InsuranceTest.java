package com.cNealgithub.hospitalManager;

import com.cNealgithub.hospitalManager.Entity.Insurance;
import com.cNealgithub.hospitalManager.Entity.Patients;
import com.cNealgithub.hospitalManager.Service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void check_assignmentOfInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("SBI20045")
                .provider("SBI BANK")
                .validUntil(LocalDate.of(2025, 12, 12))
                .build();
        insuranceService.assignInsuranceToPatient(insurance, 1);
    }
    @Test
    public void disaccociate() {
        Patients patient = insuranceService.disAssociateInsurance(1L);
        System.out.println(patient);
    }
}
