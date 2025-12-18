package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorService.createVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/{id}")
    public Visitor getVisitorById(@PathVariable Long id) {
        return visitorService.getVisitorById(id);
    }

    @PutMapping("/{id}")
    public Visitor updateVisitor(@PathVariable Long id, @RequestBody Visitor visitor) {
        return visitorService.updateVisitor(id, visitor);
    }

    @DeleteMapping("/{id}")
    public String deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
        return "Visitor deleted successfully";
    }
}
