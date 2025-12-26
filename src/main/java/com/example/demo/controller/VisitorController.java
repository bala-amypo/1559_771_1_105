package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorService.save(visitor);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.findAll();
    }
}
