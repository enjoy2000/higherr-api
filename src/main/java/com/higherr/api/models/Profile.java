package com.higherr.api.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
public class Profile extends BaseModel {

    private @ManyToOne(cascade = {CascadeType.ALL}) Company company;
    private Boolean currentlyStudying;
    private String jobTitle;
    private @ManyToOne(cascade = {CascadeType.ALL}) JobType jobType;
    private Integer yearsInCurrentRole;

    private Profile() {}

    public Profile(Company company, Boolean currentlyStudying, String jobTitle, Integer yearsInCurrentRole) {
        this.company = company;
        this.currentlyStudying = currentlyStudying;
        this.jobTitle = jobTitle;
        this.yearsInCurrentRole = yearsInCurrentRole;
    }
}
