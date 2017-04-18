package com.higherr.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "HigherrUser")
public class User extends BaseModel {

    @Column(length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(length = 100)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    @Size(min = 4, max = 100)
    private String password;

    @Column(length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(unique = true, length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    private @OneToOne(cascade = {CascadeType.ALL}) Profile profile;

    @NotNull
    private Boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserAuthority",
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Authority> authorities;

    public User(String username, String password, String firstName, String lastName, String email, Boolean enabled, Profile profile) {
        this.username = username;
        this.setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profile = profile;
        this.enabled = enabled;
    }

    private User() {}

    public void setPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    @PrePersist
    public void setRoleUser(User user) {
        
    }
}
