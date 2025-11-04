package com.cNealgithub.hospitalManager.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class patientsDTO {
    private long id;
    private String Name;
    private LocalDate dateOfBirth;
    private int age;
    private String gender;

}
