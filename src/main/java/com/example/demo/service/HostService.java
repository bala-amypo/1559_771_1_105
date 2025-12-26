package com.example.demo.service;

import com.example.demo.model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> getAllHosts();
    Optional<Host> getHostById(Long id);
    Host saveHost(Host host);
    void deleteHost(Long id);
    Host getHostByEmail(String email); // required method
}
