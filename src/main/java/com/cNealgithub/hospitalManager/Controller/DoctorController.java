package com.cNealgithub.hospitalManager.Controller;

import com.cNealgithub.hospitalManager.DTO.Doctor.DoctorDTO;
import com.cNealgithub.hospitalManager.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/api/hospital/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/list")
     public ResponseEntity<List<DoctorDTO>> doctorsList(){
         return ResponseEntity.ok(doctorService.docList());
     }
}
