package com.lucas.github.financial_planning.config.security.provider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationProvider  extends DaoAuthenticationProvider {

    public AuthenticationProvider(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    public AuthenticationProvider passwordEncoder(PasswordEncoder passwordEncoder) {
        super.setPasswordEncoder(passwordEncoder);
        return this;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AutenticationToken.class.isAssignableFrom(authentication);
    }
}
