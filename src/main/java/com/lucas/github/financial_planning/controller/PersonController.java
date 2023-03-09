package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.PersonDTO;
import com.lucas.github.financial_planning.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController extends AbstractController<PersonService> {

    @GetMapping
    public String registerPerson() {
        return getService().teste();
    }

}


