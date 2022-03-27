package com.microservices.myapp.service;

import com.microservices.myapp.model.DefaultResponse;
import com.microservices.myapp.model.ErrorSchema;
import com.microservices.myapp.model.request.EmployeeRequest;
import com.microservices.myapp.model.response.DepartmentResponse;
import com.microservices.myapp.model.response.EmployeeResponse;
import com.microservices.myapp.repo.EmployeeRepo;
import com.microservices.myapp.repo.model.Department;
import com.microservices.myapp.repo.model.Employee;
import com.microservices.myapp.repo.model.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public DefaultResponse addEmployee(EmployeeRequest employeeRequest) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = null;
        Date joinDate = new Date();

        JobTitle jobTitle = JobTitle.builder()
                .jobId(employeeRequest.getJobPositionId())
                .build();

        Department department = Department.builder()
                .deptId(employeeRequest.getDepartmentId())
                .build();

        try {
            dob = df.parse(employeeRequest.getDob());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Employee employee = Employee.builder()
                .empName(employeeRequest.getName())
                .dob(dob)
                .joinDate(joinDate)
                .jobTitle(jobTitle)
                .department(department)
                .build();

        employeeRepo.save(employee);

        DefaultResponse response = DefaultResponse.builder()
                .errorSchema(new ErrorSchema("ESB-00-000",(new ErrorSchema.ErrorMessage("success", "sukses"))))
                .build();

        return response;

    }

    public List<EmployeeResponse> getAllEmployees() {
        List<EmployeeResponse> employees = employeeRepo.findAllEmployees();
//        List<EmployeeResponse> employeeResponses = employees.stream().map(emp -> new EmployeeResponse(emp.getEmpId(), emp.getEmpName()
//                , emp.getDob(), emp.getJoinDate(), emp.getJobTitle(), emp.setDepartment()))
//                .collect(Collectors.toList());
//
//        DefaultResponse response = DefaultResponse.builder()
//                .errorSchema(new ErrorSchema("ESB-00-000",(new ErrorSchema.ErrorMessage("success", "sukses"))))
//                .outputSchema(employeeResponses)
//                .build();

//        return response;
        return employees;
    }
}
