package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.repository.UserRepository;
import com.lucas.github.financial_planning.service.LoginService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl extends AbstractService<User, Integer> implements LoginService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO authenticate(UserDTO userDTO) {
        final User user = getRepository(UserRepository.class).findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new DomainRuntimeException(EnumMessagesException.INVALID_USERNAME_OR_PASSWORD));

        if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())){
            throw new DomainRuntimeException(EnumMessagesException.INVALID_USERNAME_OR_PASSWORD);
        }

        final String token = TokenUtils.generateToken(userDTO.getUsername());
        userDTO.setToken(token);
        userDTO.setPassword(null);

        return userDTO;
    }

}
