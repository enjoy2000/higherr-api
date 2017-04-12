package com.higherr.api.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
public class Country extends BaseModel {

    @Column(unique=true)
    private String name;

    private Country() {}

    public Country(String name) {
        this.name = name;
    }
}
