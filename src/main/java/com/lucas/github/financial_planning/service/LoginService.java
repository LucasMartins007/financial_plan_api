package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.dtos.AuthDTO;
import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

public interface LoginService extends IAbstractService {
    AuthDTO authenticate(UserDTO userDTO);
}
