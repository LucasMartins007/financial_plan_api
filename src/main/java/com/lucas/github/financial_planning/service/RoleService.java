package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Role;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

public interface RoleService extends IAbstractService {

    Role findRoleByDescription(String description);
}
