package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository repository;

    public HostServiceImpl(HostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Host save(Host host) {
        return repository.save(host);
    }

    @Override
    public Optional<Host> getHost(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Host> getHostByEmail(String email) {
        return repository.findByEmail(email);
    }
}
