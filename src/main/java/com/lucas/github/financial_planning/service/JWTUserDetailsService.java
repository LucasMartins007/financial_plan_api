package com.lucas.github.financial_planning.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface JWTUserDetailsService {

    /**
     * @param username username of the user
     * @return UserDetails founded with the username passed
     * @throws UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
