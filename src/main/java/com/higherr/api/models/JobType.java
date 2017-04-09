package com.higherr.api.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class JobType extends BaseModel {

    @Column(unique=true)
    private String name;

    private JobType() {}

    public JobType(String name) {
        this.name = name;
    }
}
