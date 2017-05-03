package com.higherr.api.security;

import java.io.Serializable;

/**
 * Created by hatdao on 24/04/2017.
 */
public class JwtAuthenticationBySocialLoginRequest implements Serializable{

    private String token;

    public JwtAuthenticationBySocialLoginRequest() {

    }

    public JwtAuthenticationBySocialLoginRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
