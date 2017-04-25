package com.higherr.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 4, max = 100)
    private String token;

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

    @JsonProperty
    private @OneToOne(cascade = {CascadeType.ALL}) Profile profile;

    @NotNull
    private Boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @JsonProperty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserAuthority",
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Authority> authorities;

    @Enumerated(EnumType.STRING)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;

    @GeneratePojoBuilder
    public User(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = true;
    }

    public User() {}

    public enum SocialMediaService {
        FACEBOOK, TWITTER, LINKEDIN
    }
}
