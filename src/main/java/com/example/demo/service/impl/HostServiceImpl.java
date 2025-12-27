package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HostServiceImpl {
    private HostRepository hostRepository;

    // Required for AuthTests reflection
    public HostServiceImpl() {}

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }

    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}