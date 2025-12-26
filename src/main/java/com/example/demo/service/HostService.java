package com.example.demo.service;

import com.example.demo.model.Host;

import java.util.Optional;

public interface HostService {
    Host createHost(Host host);
    Optional<Host> getHost(Long id);
    Host getHostByEmail(String email);
}
