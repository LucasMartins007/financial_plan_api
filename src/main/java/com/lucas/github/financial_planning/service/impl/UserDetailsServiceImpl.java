package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.repository.UserRepository;
import com.lucas.github.financial_planning.service.JWTUserDetailsService;
import com.lucas.github.financial_planning.utils.Utils;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@NoArgsConstructor
public class UserDetailsServiceImpl implements JWTUserDetailsService, UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsernameAndActiveTrue(username);
        if (Utils.isEmpty(user)) {
            throw new DomainRuntimeException(EnumMessagesException.USER_NOT_FOUND);
        }
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), new ArrayList<>());
    }
}
