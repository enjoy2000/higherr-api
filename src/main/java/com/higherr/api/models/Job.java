package com.higherr.api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Job extends BaseModel {

    private String title;
    private @ManyToOne(cascade = {CascadeType.ALL}) Company company;
    private @ManyToOne(cascade = {CascadeType.ALL}) City city;
    private String department;
    private EmploymentType employmentType;
    private String description;
    private String responsibilities;
    private String requirements;
    private Integer referQuestionGroup;
    @Column(unique=true)
    private String officialUrl;
    private @ManyToOne(cascade={CascadeType.ALL}) User author;

    private Job() {}


    public Job(String title, Company company, City city, String department,
               EmploymentType employmentType, String description, String responsibilities, String requirements,
               int referQuestionGroup, String officialUrl, User author) {
        this.title = title;
        this.company = company;
        this.city = city;
        this.department = department;
        this.employmentType = employmentType;
        this.description = description;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
        this.referQuestionGroup = referQuestionGroup;
        this.officialUrl = officialUrl;
        this.author = author;
    }
}
