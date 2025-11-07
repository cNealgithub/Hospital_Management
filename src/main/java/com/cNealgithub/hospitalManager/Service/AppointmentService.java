package com.cNealgithub.hospitalManager.Service;

import com.cNealgithub.hospitalManager.Entity.Appointment;

public interface AppointmentService {

    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId);
    public Appointment reassignDocToAppointment(Long appointmentId, Long doctorId);
}
