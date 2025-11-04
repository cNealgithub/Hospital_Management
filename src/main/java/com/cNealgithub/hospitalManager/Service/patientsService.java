package com.cNealgithub.hospitalManager.Service;

import com.cNealgithub.hospitalManager.DTO.patientsDTO;
import com.cNealgithub.hospitalManager.DTO.registerPatientDTO;

import java.util.List;
import java.util.Map;

public interface patientsService {
    List<patientsDTO> getAllPatients();

    patientsDTO getPatientById(long id);

    patientsDTO addPatient(registerPatientDTO registerPatientDTO);

    void deletePatient(long id);

    patientsDTO fullUpdate(long id, registerPatientDTO registerPatientDTO);

    patientsDTO patchUpdate(long id, Map<String, Object> updates);
}
