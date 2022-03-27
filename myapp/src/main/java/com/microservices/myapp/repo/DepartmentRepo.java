package com.microservices.myapp.repo;

import com.microservices.myapp.repo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
