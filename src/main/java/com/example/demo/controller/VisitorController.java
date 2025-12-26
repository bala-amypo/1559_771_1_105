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
        return visitorService.createVisitor(visitor);
    }

    @GetMapping("/{id}")
    public Visitor getVisitor(@PathVariable Long id) {
        return visitorService.getVisitor(id);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @DeleteMapping("/{id}")
    public String deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
        return "Visitor deleted successfully";
    }
}
