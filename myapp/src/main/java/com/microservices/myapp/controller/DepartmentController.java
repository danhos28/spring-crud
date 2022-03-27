package com.microservices.myapp.controller;

import com.microservices.myapp.model.DefaultResponse;
import com.microservices.myapp.model.request.DepartmentRequest;
import com.microservices.myapp.model.response.DepartmentResponse;
import com.microservices.myapp.repo.model.Department;
import com.microservices.myapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
@Validated
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DefaultResponse> addDepartment(@Valid @RequestBody DepartmentRequest department) {
        DefaultResponse responseBody = departmentService.addDepartment(department);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllDepartment() {
        DefaultResponse responseBody = departmentService.getAllDepartment();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
