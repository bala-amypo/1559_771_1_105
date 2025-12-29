package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.impl.HostServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Schema(name = "Hosts", description = "Host/Employee management")
public class HostController {
    private final HostServiceImpl hostService;

    public HostController(HostServiceImpl hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<Host> create(@RequestBody Host host) {
        return new ResponseEntity<>(hostService.createHost(host), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> getById(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getHost(id));
    }
}