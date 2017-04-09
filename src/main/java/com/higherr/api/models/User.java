package com.higherr.api.models;

import javax.persistence.*;
import org.springframework.data.rest.core.config.Projection;

import lombok.Data;

@Data
@Entity
@Table(name = "HigherrUser")
public class User extends BaseModel {

    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private @OneToOne(cascade = {CascadeType.ALL}) Profile profile;

    private User() {}

    public User(String firstName, String lastName, String email, Profile profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profile = profile;
    }
}
