package com.example.demo.repository;

import com.example.demo.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    // This allows the service to find visitors by their email string
    Optional<Visitor> findByEmail(String email);
}