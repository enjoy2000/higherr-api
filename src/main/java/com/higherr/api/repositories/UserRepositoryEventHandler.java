package com.higherr.api.repositories;

import com.higherr.api.models.Authority;
import com.higherr.api.models.AuthorityName;
import com.higherr.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by hatdao on 18/04/2017.
 */
@Component
@RepositoryEventHandler(User.class)
public class UserRepositoryEventHandler {

    @Autowired
    private AuthorityRepository authorityRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @HandleBeforeCreate
    public void handleUserCreate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Authority roleUser = authorityRepository.findByName(AuthorityName.ROLE_USER);
        if (roleUser == null) {
            roleUser = authorityRepository.save(new Authority(AuthorityName.ROLE_USER));
        }

        List<Authority> authorities = Collections.singletonList(roleUser);
        user.setAuthorities(authorities);
    }
}