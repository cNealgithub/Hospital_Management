package com.cNealgithub.hospitalManager.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class registerPatientDTO {

    private String Name;
    private LocalDate dateOfBirth;
    private int age;
    private String gender;
    private String bloodGroup;
}
