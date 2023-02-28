package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.service.LoginService;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public UserDTO authenticate(@RequestBody UserDTO userDTO){
        return loginService.authenticate(userDTO);
    }

}
