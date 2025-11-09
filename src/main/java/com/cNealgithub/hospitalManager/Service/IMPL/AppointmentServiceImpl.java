package com.cNealgithub.hospitalManager.Service.IMPL;

import com.cNealgithub.hospitalManager.DTO.createAppointmentDTO;
import com.cNealgithub.hospitalManager.Entity.Appointment;
import com.cNealgithub.hospitalManager.Entity.Doctor;
import com.cNealgithub.hospitalManager.Entity.Patients;
import com.cNealgithub.hospitalManager.Repository.AppointmentRepository;
import com.cNealgithub.hospitalManager.Repository.DoctorRepository;
import com.cNealgithub.hospitalManager.Repository.patientsRepository;
import com.cNealgithub.hospitalManager.Service.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final patientsRepository patientsRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doc = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + doctorId));
        Patients patient = patientsRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        //checking if appointment is already present
        if(appointment.getId() != 0) throw new IllegalArgumentException("Appointment already present");
        //as appointment is the owner so:-
        appointment.setPatient(patient);
        appointment.setDoctor(doc);

        patient.getAppointments().add(appointment);//to maintain bidirectional mapping
        //saving this appointment
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    @Transactional
    public Appointment reassignDocToAppointment(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);

        return appointment;
    }

    @Override
    public createAppointmentDTO createNewAppointment(createAppointmentDTO createAppointmentDTO) {
        long patientId = createAppointmentDTO.getPatientId();
        long doctorId = createAppointmentDTO.getDoctorId();

        Patients patient = patientsRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient Not Found with id: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor Not Found with id:" + doctorId));
        Appointment appointment = Appointment.builder()
                .appointmentTime(createAppointmentDTO.getAppointmentTime())
                .reason(createAppointmentDTO.getReason())
                .build();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);

        appointment = appointmentRepository.save(appointment);
        System.out.println(patient.getId());
        return modelMapper.map(appointment, createAppointmentDTO.class);
    }

}
