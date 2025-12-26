package com.example.demo.service;

import com.example.demo.model.Host;
import java.util.Optional;

public interface HostService {

    Host save(Host host);

    Optional<Host> getHost(Long id);

    Optional<Host> getHostByEmail(String email);
}
