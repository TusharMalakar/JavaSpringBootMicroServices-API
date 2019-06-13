package com.JavaAPI_SpringBoot.Home.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 *
 * @author Tushar Malakar
 */


public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
