package com.higherr.api.security.service;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

/**
 * Created by hatdao on 24/04/2017.
 */
public class SocialAuthenticationService {

    String token;

    Facebook facebook;

    public SocialAuthenticationService(String token) {
        this.token = token;
        facebook = new FacebookTemplate(token);
    }

    public boolean isValidToken() {
        try {
            facebook.userOperations().getUserProfile();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public User getUserProfile() {
        return facebook.userOperations().getUserProfile();
    }
}
