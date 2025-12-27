package com.example.demo.repository;

import com.example.demo.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HostRepository extends JpaRepository<Host, Long> {
    Optional<Host> findByEmail(String email); // Used for test037 and test047 [cite: 161, 163]
}