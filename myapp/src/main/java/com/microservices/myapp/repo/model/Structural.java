package com.microservices.myapp.repo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "STRUCTURAL")
public class Structural implements Serializable {
    @Id
    @Column(name = "STRUCTURAL_ID")
    private Integer structuralId;
    @Column(name = "STRUCTURAL_NAME")
    private String structuralName;
    @JsonIgnore
    @OneToMany(targetEntity = Department.class, mappedBy = "structural", cascade = CascadeType.ALL)
    private Set<Department> departments;
//    @OneToMany
//    @JoinColumn(name="departments")
//    private Set<Department> departments;
}
