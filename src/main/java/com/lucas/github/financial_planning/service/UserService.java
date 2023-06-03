package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

public interface UserService extends IAbstractService {

    User registerNewUser(User user);

    User loadUserByUsername(String username);
}
