package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.AuthDTO;
import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<AuthDTO> authenticate(@RequestBody UserDTO userDTO){
        final AuthDTO authDTO = loginService.authenticate(userDTO);

        return ResponseEntity.ok(authDTO);
    }

}
