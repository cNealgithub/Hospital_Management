package com.cNealgithub.hospitalManager.DTO;

import com.cNealgithub.hospitalManager.DTO.Doctor.DoctorDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private DoctorDTO doctor;
}
