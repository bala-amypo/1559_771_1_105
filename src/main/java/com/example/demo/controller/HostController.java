package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public Host createHost(@RequestBody Host host) {
        return hostService.save(host);
    }
}
