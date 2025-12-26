package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hosts")
public class HostController {

    private final HostService hostService;

    @Autowired
    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<Host> createHost(@RequestBody Host host) {
        return ResponseEntity.ok(hostService.createHost(host));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> getHost(@PathVariable Long id) {
        Host host = hostService.getHost(id)
                .orElseThrow(() -> new RuntimeException("Host not found"));
        return ResponseEntity.ok(host);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Host> getHostByEmail(@PathVariable String email) {
        return ResponseEntity.ok(hostService.getHostByEmail(email));
    }
}
