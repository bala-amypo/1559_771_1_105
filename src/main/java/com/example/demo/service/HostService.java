package com.example.visitor.service;

import java.util.List;
import com.example.visitor.model.Host;
import com.example.visitor.exception.NotFoundException;

public interface HostService {
    void createHost(Host host);
    Host getHost(Long id) throws NotFoundException;
    List<Host> getAllHosts();
}
