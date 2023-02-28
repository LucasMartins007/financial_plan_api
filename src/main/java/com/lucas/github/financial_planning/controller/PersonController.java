package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/teste")
public class PersonController {

    private PersonService personService;

    @GetMapping
    public String getAll() {
        return personService.teste();
    }

    @PostMapping
    public String get(@Valid @RequestBody UserDTO userDTO) {

        return "ok";
    }

}


