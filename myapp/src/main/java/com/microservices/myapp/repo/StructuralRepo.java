package com.microservices.myapp.repo;

import com.microservices.myapp.repo.model.Structural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructuralRepo extends JpaRepository<Structural, Integer> {
}
