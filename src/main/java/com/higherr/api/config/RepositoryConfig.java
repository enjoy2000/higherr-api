package com.higherr.api.config;

import com.higherr.api.models.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by hatdao on 09/04/2017.
 */
@Configuration
public class RepositoryConfig extends
        RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class, Profile.class, Company.class, JobType.class);
    }
}