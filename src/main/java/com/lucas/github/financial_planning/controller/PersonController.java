package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController extends AbstractController<PersonService> {

    @GetMapping
    public String registerPerson() {
        return "teste";
    }

}


