package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AppointmentService;
import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public AppointmentServiceImpl(AppointmentRepository ar, VisitorRepository vr, HostRepository hr) {
        this.appointmentRepository = ar;
        this.visitorRepository = vr;
        this.hostRepository = hr;
    }

    public Appointment createAppointment(Long visitorId, Long hostId, Appointment appointment) {
        if (appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("appointmentDate cannot be past");
        }
        
        Visitor v = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        Host h = hostRepository.findById(hostId)
                .orElseThrow(() -> new RuntimeException("Host not found"));

        appointment.setVisitor(v);
        appointment.setHost(h);
        appointment.setStatus("SCHEDULED");
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public List<Appointment> getAppointmentsForHost(Long hostId) {
        return appointmentRepository.findByHostId(hostId);
    }

    public List<Appointment> getAppointmentsForVisitor(Long visitorId) {
        return appointmentRepository.findByVisitorId(visitorId);
    }
}