package com.example.demo.service;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    @Autowired
    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> getHostById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Host saveHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public void deleteHost(Long id) {
        hostRepository.deleteById(id);
    }
}
