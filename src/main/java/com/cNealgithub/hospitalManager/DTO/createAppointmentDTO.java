package com.cNealgithub.hospitalManager.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class createAppointmentDTO {

    private long patientId;
    private long doctorId;
    private String reason;
    private LocalDateTime appointmentTime;
}
