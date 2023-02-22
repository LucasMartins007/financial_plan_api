package com.lucas.github.financial_planning.config.security.provider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AutenticationToken extends UsernamePasswordAuthenticationToken {

    public AutenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
