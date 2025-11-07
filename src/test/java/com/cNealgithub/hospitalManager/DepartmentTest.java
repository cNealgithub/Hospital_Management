package com.cNealgithub.hospitalManager;

import com.cNealgithub.hospitalManager.Entity.Department;
import com.cNealgithub.hospitalManager.Entity.Doctor;
import com.cNealgithub.hospitalManager.Repository.DoctorRepository;
import com.cNealgithub.hospitalManager.Service.DepartmentService;
import com.cNealgithub.hospitalManager.Service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class DepartmentTest {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DepartmentService departmentService;
    @Test
    public void addDeptTest(){
        Doctor doc1 = doctorRepository.findById(3L).orElseThrow();
        Doctor doc2 = doctorRepository.findById(4L).orElseThrow();
        Set<Doctor> docsOfCardio = new HashSet<>();
        docsOfCardio.add(doc1);
        docsOfCardio.add(doc2);
        Department cardioDept = Department.builder()
                .name("Cardio")
                .headDoctor(doctorRepository.findById(1L).orElseThrow())
                .doctors(docsOfCardio)
                .build();
        departmentService.addDeptInfo(cardioDept);
    }
}
