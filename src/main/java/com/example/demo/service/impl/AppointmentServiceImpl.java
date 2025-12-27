package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceImpl {
    private final AppointmentRepository appointmentRepository;
    private final VisitorRepository visitorRepository;
    private final HostRepository hostRepository; [cite: 214]

    public AppointmentServiceImpl(AppointmentRepository ar, VisitorRepository vr, HostRepository hr) {
        this.appointmentRepository = ar;
        this.visitorRepository = vr;
        this.hostRepository = hr; [cite: 213]
    }

    public Appointment createAppointment(Long visitorId, Long hostId, Appointment appointment) {
        if (appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("appointmentDate cannot be past"); [cite: 215]
        }
        appointment.setVisitor(visitorRepository.findById(visitorId).orElseThrow());
        appointment.setHost(hostRepository.findById(hostId).orElseThrow());
        appointment.setStatus("SCHEDULED"); [cite: 216]
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found")); [cite: 217]
    }

    public List<Appointment> getAppointmentsForHost(Long hostId) { return appointmentRepository.findByHostId(hostId); } [cite: 210]
    public List<Appointment> getAppointmentsForVisitor(Long visitorId) { return appointmentRepository.findByVisitorId(visitorId); } [cite: 211]
}