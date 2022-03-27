package com.microservices.myapp.service;

import com.microservices.myapp.model.DefaultResponse;
import com.microservices.myapp.model.ErrorSchema;
import com.microservices.myapp.model.request.DepartmentRequest;
import com.microservices.myapp.model.response.DepartmentResponse;
import com.microservices.myapp.repo.DepartmentRepo;
import com.microservices.myapp.repo.model.Department;
import com.microservices.myapp.repo.model.Structural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public DefaultResponse addDepartment(DepartmentRequest deptRequest) {
        Structural structural = Structural.builder()
                .structuralId(deptRequest.getStructuralId())
                .build();

        Department department = Department.builder().deptId(deptRequest.getDepartmentId())
                .deptName(deptRequest.getDepartmentName())
                .location(deptRequest.getLocation())
                .structural(structural)
                .build();

        departmentRepo.save(department);

//        DepartmentResponse departmentResponse = DepartmentResponse.builder()
//                .departmentId(deptRequest.getDepartmentId())
//                .departmentName(deptRequest.getDepartmentName())
//                .location(deptRequest.getLocation())
//                .build();

        DefaultResponse response = DefaultResponse.builder()
                .errorSchema(new ErrorSchema("ESB-00-000",(new ErrorSchema.ErrorMessage("success", "sukses"))))
                .build();

        return response;
    }

    public DefaultResponse getAllDepartment() {
        List<Department> departments = departmentRepo.findAll();
        List<DepartmentResponse> departmentResponses = departments.stream().map(dept -> new DepartmentResponse(dept.getDeptId(), dept.getDeptName(), dept.getLocation()))
               .collect(Collectors.toList());

        DefaultResponse response = DefaultResponse.builder()
                .errorSchema(new ErrorSchema("ESB-00-000",(new ErrorSchema.ErrorMessage("success", "sukses"))))
                .outputSchema(departmentResponses)
                .build();

        return response;

    }
}
