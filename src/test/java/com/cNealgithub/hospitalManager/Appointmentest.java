package com.cNealgithub.hospitalManager;

import com.cNealgithub.hospitalManager.Entity.Appointment;
import com.cNealgithub.hospitalManager.Repository.AppointmentRepository;
import com.cNealgithub.hospitalManager.Service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class Appointmentest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAppointmentCreation(){
        Appointment appointment1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,10,17,10,30,00))
                .reason("Cancer")
                .build();
       var newAppointment = appointmentService.createAppointment(appointment1, 2L, 5L);
        System.out.println(newAppointment);
    }
    @Test
    public void reAssignDctorToAppointment(){
        var updatedAppointment = appointmentService.reassignDocToAppointment(3L, 2L);
        System.out.println(updatedAppointment);
    }
}

