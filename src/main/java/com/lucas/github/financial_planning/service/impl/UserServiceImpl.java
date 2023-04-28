package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.repository.UserRepository;
import com.lucas.github.financial_planning.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
