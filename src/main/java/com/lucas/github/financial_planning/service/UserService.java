package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.User;

public interface UserService {

    User loadUserByUsername(String username);
}
