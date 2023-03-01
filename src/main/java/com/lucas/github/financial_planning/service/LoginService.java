package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.dtos.AuthDTO;
import com.lucas.github.financial_planning.model.dtos.UserDTO;

public interface LoginService {
    AuthDTO authenticate(UserDTO userDTO);
}
