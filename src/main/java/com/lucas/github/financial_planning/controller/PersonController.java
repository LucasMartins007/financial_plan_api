package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.PersonDTO;
import com.lucas.github.financial_planning.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController extends AbstractController<PersonService> {


    @PostMapping(value = "/register")
    public String registerPerson(PersonDTO personDTO) {

        return "teste";
    }

}


