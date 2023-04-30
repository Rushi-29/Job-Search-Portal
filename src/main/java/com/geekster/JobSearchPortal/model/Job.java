package com.geekster.JobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Location is required")
    private String location;
    @NotNull(message = "Salary is required")
    private Double salary;
    @NotBlank(message = "Company name is required")
    private String companyName;
    @NotBlank(message = "Employer name is required")
    private String employerName;
    @NotNull(message = "Job type is required")
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
