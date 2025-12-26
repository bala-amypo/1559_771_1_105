package com.example.demo.service.impl;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public List<Appointment> getByHost(Long hostId) {
        return repository.findByHostId(hostId);
    }

    @Override
    public List<Appointment> getByVisitor(Long visitorId) {
        return repository.findByVisitorId(visitorId);
    }
}
