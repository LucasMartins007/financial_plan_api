package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.PersonDTO;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/person")
public class PersonController extends AbstractController<PersonService> {


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO registerPerson(@RequestBody PersonDTO personDTO) {
        final Person person = convertDTOToEntity(personDTO, Person.class);

        final Person managedPerson = getService().registerNewPerson(person);

        return convertEntityToDTO(managedPerson, PersonDTO.class);
    }

}


