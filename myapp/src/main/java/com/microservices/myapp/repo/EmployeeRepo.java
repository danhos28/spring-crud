package com.microservices.myapp.repo;

import com.microservices.myapp.model.response.EmployeeResponse;
import com.microservices.myapp.repo.model.Department;
import com.microservices.myapp.repo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT new com.microservices.myapp.model.response.EmployeeResponse(e.empId, e.empName, e.dob, e.joinDate, " +
            "j.jobTitle, s.structuralName, d.deptName) FROM Employee e " +
            "JOIN e.department d " +
            "JOIN d.structural s " +
            "JOIN e.jobTitle j ")
    public List<EmployeeResponse> findAllEmployees();
}
