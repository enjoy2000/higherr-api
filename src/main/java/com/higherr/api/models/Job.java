package com.higherr.api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Job {

    private @Id @GeneratedValue Long id;

    private String jobTitle;
    private String companyName;
    private String jobCity; //multiple cities stored as csv
    private String jobCountry; //multiple countries stored as csv
    private String department;
    private String employmentType;
    private String jobDescription;
    private String jobResponsibilities;
    private String jobRequirements;
    private Integer referQuestionGroup;
    private String jobOfficialUrl;
    private @ManyToOne(cascade={CascadeType.ALL}) User author;

    private Job() {}


    public Job(String jobTitle, String companyName, String jobCity, String jobCountry, String department,
               String employmentType, String jobDescription, String jobResponsibilities, String jobRequirements,
               int referQuestionGroup, String jobOfficialUrl, User author) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobCity = jobCity;
        this.jobCountry = jobCountry;
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
