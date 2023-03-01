package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.dtos.AuthDTO;
import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.repository.PersonRepository;
import com.lucas.github.financial_planning.repository.UserRepository;
import com.lucas.github.financial_planning.service.LoginService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl extends AbstractService<User, Integer> implements LoginService {

    private final PasswordEncoder passwordEncoder;

    private final TokenServiceImpl tokenService;

    @Override
    public AuthDTO authenticate(UserDTO userDTO) {
        final User user = getRepository(UserRepository.class).findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new DomainRuntimeException(EnumMessagesException.INVALID_USERNAME_OR_PASSWORD));
        if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())){
            throw new DomainRuntimeException(EnumMessagesException.INVALID_USERNAME_OR_PASSWORD);
        }
        final Integer personId = getRepository(PersonRepository.class).findIdByUser(user);
        final String token = tokenService.generateToken(userDTO.getUsername());
        final Date expirationDate = tokenService.getExpirationDateFromToken(token);
        final String refreshToken = tokenService.generateRefreshToken(user.getUsername());

        return AuthDTO.builder()
                .token(token)
                .username(userDTO.getUsername())
                .personId(personId)
                .expirationDate(expirationDate)
                .refreshToken(refreshToken)
                .build();
    }

}
