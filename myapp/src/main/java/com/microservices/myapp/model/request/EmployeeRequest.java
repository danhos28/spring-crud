package com.microservices.myapp.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.microservices.myapp.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "name")
    private String name;

    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "dob")
    private String dob;

//    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "join_date")
//    private String joinDate;

    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "job_position_id")
    private Integer jobPositionId;

    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "department_id")
    private Integer departmentId;
}
