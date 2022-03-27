package com.microservices.myapp.repo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Department implements Serializable {
    @Id
    @Column(name = "DEPT_ID")
    private Integer deptId;
    @Column(name = "DEPT_NAME")
    private String deptName;
    @Column(name = "LOCATION")
    private String location;
    @ManyToOne
    @JoinColumn(name = "STRUCTURAL_ID", referencedColumnName = "STRUCTURAL_ID")
    private Structural structural;

}
