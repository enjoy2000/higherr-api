package com.higherr.api.projections;

import com.higherr.api.models.Profile;
import com.higherr.api.models.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

/**
 * Created by hatdao on 09/04/2017.
 */
@Projection(name = "profile", types = User.class)
public interface UserWithProfileProjection {
    long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    Date getCreatedAt();
    Date getUpdatedAt();
    Profile getProfile();
}
