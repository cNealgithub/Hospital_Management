package com.cNealgithub.hospitalManager.Service.IMPL;

import com.cNealgithub.hospitalManager.DTO.Doctor.DoctorDTO;
import com.cNealgithub.hospitalManager.Entity.Doctor;
import com.cNealgithub.hospitalManager.Repository.DoctorRepository;
import com.cNealgithub.hospitalManager.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorDTO> docList() {
        List<Doctor> docs = doctorRepository.findAll();
        List<DoctorDTO> docsDto = docs
                .stream().map(Doctor -> new DoctorDTO(Doctor.getId(), Doctor.getName(), Doctor.getEmail(), Doctor.getSpecialization()))
                .toList();
        return docsDto;
    }
}
