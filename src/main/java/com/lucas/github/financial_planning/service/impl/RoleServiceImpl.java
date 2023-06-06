package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Role;
import com.lucas.github.financial_planning.repository.RoleRepository;
import com.lucas.github.financial_planning.service.RoleService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends AbstractService<Role, Integer> implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findRoleByDescription(String description) {
        final Role role = roleRepository.findByRoleDescription(description.toUpperCase());
        if (Utils.isEmpty(role)) {
            throw new DomainRuntimeException(EnumMessagesException.ROLE_NOT_FOUND, description);
        }
        return role;
    }
}
