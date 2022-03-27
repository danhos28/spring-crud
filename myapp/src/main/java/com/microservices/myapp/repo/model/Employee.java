package com.microservices.myapp.repo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {
    //implements Serializable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "DOB", columnDefinition = "DATE")
    private Date dob;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "JOIN_DATE", columnDefinition = "DATE")
    private Date joinDate;

    @ManyToOne
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
    private Department department;

//    @ManyToOne
//    @JoinColumn(name = "STRUCTURAL_ID", referencedColumnName = "STRUCTURAL_ID")
//    private Structural structural;
}
