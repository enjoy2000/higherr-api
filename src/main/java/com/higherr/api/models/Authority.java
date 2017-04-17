package com.higherr.api.models;

/**
 * Created by hatdao on 17/04/2017.
 */
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Authority extends BaseModel {

    @Column(length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<User> users;

    private Authority() {}

    public Authority(AuthorityName name) {
        this.name = name;
    }

    public AuthorityName authority() {
        return this.name;
    }
}
