package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Role;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.repository.UserRepository;
import com.lucas.github.financial_planning.service.RoleService;
import com.lucas.github.financial_planning.service.UserService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.ContextUtils;
import com.lucas.github.financial_planning.utils.Utils;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(User user) {
        Validator.validate(EnumValidators.USER, user);
        validateDuplicatedUsername(user.getUsername());
        criptPassword(user);

        user.setIncludeDate(new Date());
        user.setUpdateDate(new Date());
        user.setActive(true);

        final Role role = getUserRole(user.getRole());
        user.setRole(role);

        return userRepository.save(user);
    }

    private void criptPassword(User user) {
        final String criptPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(criptPassword);
    }

    private Role getUserRole(Role role) {
        return getService(RoleService.class).findRoleByDescription(role.getRoleDescription());
    }

    private void validateDuplicatedUsername(String username) {
        final User managedUser = userRepository.findByUsernameAndActiveTrue(username);
        if (Utils.isNotEmpty(managedUser)) {
            throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_USERNAME, username);
        }
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsernameAndActiveTrue(username);
    }
}
