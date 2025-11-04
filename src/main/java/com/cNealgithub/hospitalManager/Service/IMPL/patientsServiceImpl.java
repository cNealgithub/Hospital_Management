package com.cNealgithub.hospitalManager.Service.IMPL;

import com.cNealgithub.hospitalManager.DTO.patientsDTO;
import com.cNealgithub.hospitalManager.DTO.registerPatientDTO;
import com.cNealgithub.hospitalManager.Entity.Patients;
import com.cNealgithub.hospitalManager.Repository.patientsRepository;
import com.cNealgithub.hospitalManager.Service.patientsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class patientsServiceImpl implements patientsService {

    private final patientsRepository patientsRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<patientsDTO> getAllPatients() {
        List<Patients> allPatients = patientsRepository.findAll();
        List<patientsDTO> allPatientsDTO = allPatients
                .stream()
                .map(Patients -> new patientsDTO(Patients.getId(), Patients.getName(), Patients.getDateOfBirth(), Patients.getAge(), Patients.getGender()))
                .toList();
        return allPatientsDTO;
    }

    @Override
    public patientsDTO getPatientById(long id) {
        Patients patients = patientsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found with id : " + id));
        return modelMapper.map(patients, patientsDTO.class);
    }

    @Override
    public patientsDTO addPatient(registerPatientDTO registerPatientDTO) {
        Patients newpatients = modelMapper.map(registerPatientDTO, Patients.class);
        Patients savedPatients =patientsRepository.save(newpatients);
        return modelMapper.map(savedPatients, patientsDTO.class);
    }

    @Override
    public void deletePatient(long id) {
        patientsRepository.deleteById(id);
    }

    @Override
    public patientsDTO fullUpdate(long id, registerPatientDTO registerPatientDTO) {
        Patients patients = patientsRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("patient Not found"));
        modelMapper.map(registerPatientDTO, patients);
        patientsRepository.save(patients);
        return modelMapper.map(patients, patientsDTO.class);
    }

    @Override
    public patientsDTO patchUpdate(long id, Map<String, Object> updates) {
        Patients patients = patientsRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("patient Not found"));
        updates.forEach((field, value) ->{
            switch(field){
                case "name": patients.setName((String) value);
                break;
                case "dateOfBirth":
                    if (value instanceof String dobStr) {
                        try {
                            LocalDate dob = LocalDate.parse(dobStr); // ISO format: yyyy-MM-dd
                            patients.setDateOfBirth(dob);
                        } catch (DateTimeParseException e) {
                            throw new IllegalArgumentException("Invalid date format for dateOfBirth");
                        }
                    }
                    break;

                case "age": // lowercase "age" to match JSON key
                    if (value instanceof Integer ageInt) {
                        patients.setAge(ageInt);
                    } else if (value instanceof String ageStr) {
                        try {
                            patients.setAge(Integer.parseInt(ageStr));
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid number format for age");
                        }
                    }
                    break;

                case "gender": patients.setGender((String) value);
                break;
                default:
                   throw  new IllegalArgumentException("Invalid field");
            }
        });
        patientsRepository.save(patients);
        return modelMapper.map(patients, patientsDTO.class);
    }
}
