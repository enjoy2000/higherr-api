package com.higherr.api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Company extends BaseModel {

//    @Column(unique=true)
    private String name;

    private Company() {}

    public Company(String name) {
        this.name = name;
    }
}
