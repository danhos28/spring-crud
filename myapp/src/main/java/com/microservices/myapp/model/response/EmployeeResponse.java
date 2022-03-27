package com.microservices.myapp.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.SqlResultSetMapping;
import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
@AllArgsConstructor
public class EmployeeResponse {
    private Long employeeId;
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date joinDate;
    private String jobTitle;
    private String structural;
    private String department;
}
