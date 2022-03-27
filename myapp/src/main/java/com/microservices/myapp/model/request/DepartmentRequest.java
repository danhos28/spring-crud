package com.microservices.myapp.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.microservices.myapp.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "department_id")
    private Integer departmentId;

    @NotBlank(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "department_name")
    private String departmentName;

    @NotBlank(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "location")
    private String location;

    @NotNull(message = Constants.MISSING_MANDATORY_FIELD + Constants.MISSING_MANDATORY_FIELD + "structural_id")
    private Integer structuralId;
}
