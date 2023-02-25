package com.lucas.github.financial_planning.controller;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.lucas.github.financial_planning.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teste")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public String getAll() {
        return personService.teste();
    }

}
