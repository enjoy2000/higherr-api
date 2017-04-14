package com.higherr.api.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
public class City extends BaseModel {

    private String name;
    private @ManyToOne(cascade={CascadeType.ALL}) Country country;

    private City() {}

    public City(String name, Country country) {

        this.name = name;
        this.country = country;
    }
}
