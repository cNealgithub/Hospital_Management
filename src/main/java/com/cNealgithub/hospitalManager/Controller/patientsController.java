package com.cNealgithub.hospitalManager.Controller;

import com.cNealgithub.hospitalManager.DTO.patientsDTO;
import com.cNealgithub.hospitalManager.DTO.registerPatientDTO;
import com.cNealgithub.hospitalManager.Service.patientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hospital")
public class patientsController {

    private final patientsService patientsService;

    @GetMapping("/patientsList")
    public ResponseEntity<List<patientsDTO>> getAllPatientsList(){
        return ResponseEntity.ok(patientsService.getAllPatients());
    }
    @GetMapping("/patients/{id}")
    public ResponseEntity<patientsDTO> getPatientById(@PathVariable long id){
        return ResponseEntity.ok(patientsService.getPatientById(id));
    }
    @PostMapping("/registerPatient")
    public ResponseEntity<patientsDTO> addPatient(@RequestBody registerPatientDTO registerPatientDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientsService.addPatient(registerPatientDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable long id){
        patientsService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/putUpdate/{id}")
    public ResponseEntity<patientsDTO> fullUpdate(@PathVariable long id, @RequestBody registerPatientDTO registerPatientDTO){
        return ResponseEntity.ok(patientsService.fullUpdate(id, registerPatientDTO));
    }
    @PatchMapping("/patchUpdate/{id}")
    public ResponseEntity<patientsDTO> patchUpdatePatient(@PathVariable long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(patientsService.patchUpdate(id, updates));
    }
}
