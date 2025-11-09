package com.cNealgithub.hospitalManager.DTO.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private long id;
    private String name;
    private String specialization;
    private String email;
}
