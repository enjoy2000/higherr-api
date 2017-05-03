package com.higherr.api.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by hatdao on 24/04/2017.
 */
public interface JwtUserDetailsService extends UserDetailsService {

    UserDetails loadUserByEmail(String email);
}
