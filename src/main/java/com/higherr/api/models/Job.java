package com.higherr.api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Job extends BaseModel {

    private @Id @GeneratedValue Long id;

    private String jobTitle;
    private Company company;
    private City jobCity;
    private String department;
    private EmploymentType employmentType;
    private String jobDescription;
    private String jobResponsibilities;
    private String jobRequirements;
    private Integer referQuestionGroup;
    @Column(unique=true)
    private String jobOfficialUrl;
    private @ManyToOne(cascade={CascadeType.ALL}) User author;

    private Job() {}


    public Job(String jobTitle, Company company, City jobCity, String department,
               EmploymentType employmentType, String jobDescription, String jobResponsibilities, String jobRequirements,
               int referQuestionGroup, String jobOfficialUrl, User author) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.jobCity = jobCity;
        this.department = department;
        this.employmentType = employmentType;
        this.jobDescription = jobDescription;
        this.jobResponsibilities = jobResponsibilities;
        this.jobRequirements = jobRequirements;
        this.referQuestionGroup = referQuestionGroup;
        this.jobOfficialUrl = jobOfficialUrl;
        this.author = author;
    }
}
