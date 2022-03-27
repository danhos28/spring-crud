package com.microservices.myapp.repo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "JOB_TITLE")
public class JobTitle {
    @Id
    @Column(name = "JOB_ID")
    private Integer jobId;
    @Column(name = "JOB_TITLE")
    private String jobTitle;
}
