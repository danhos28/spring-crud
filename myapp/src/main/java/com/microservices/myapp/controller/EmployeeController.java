package com.microservices.myapp.controller;

import com.microservices.myapp.model.DefaultResponse;
import com.microservices.myapp.model.request.EmployeeRequest;
import com.microservices.myapp.model.response.EmployeeResponse;
import com.microservices.myapp.repo.model.Employee;
import com.microservices.myapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<DefaultResponse> addEmployee(@Valid @RequestBody EmployeeRequest employee) {
        DefaultResponse responseBody = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping
     private List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
