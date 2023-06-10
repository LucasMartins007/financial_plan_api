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
@RequestMapping(LoginController.PATH)
@RequiredArgsConstructor
public class LoginController extends AbstractController<LoginService> {

    public static final String PATH = "login";

    @PostMapping
    public ResponseEntity<AuthDTO> authenticate(@RequestBody UserDTO userDTO) {
        final AuthDTO authDTO = getService().authenticate(userDTO);

        return ResponseEntity.ok(authDTO);
    }

}
