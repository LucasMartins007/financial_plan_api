package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.PersonDTO;
import com.lucas.github.financial_planning.model.dtos.PersonResponseDTO;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PersonController.PATH)
public class PersonController extends AbstractController<PersonService> {

    public static final String PATH = "person";

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponseDTO registerPerson(@RequestBody PersonDTO personDTO) {
        final Person person = convertDTOToEntity(personDTO, Person.class);

        final Person managedPerson = getService().registerNewPerson(person);

        return convertEntityToDTO(managedPerson, PersonResponseDTO.class);
    }

    @GetMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponseDTO getPersonById(@PathVariable("personId") Integer personId) {
        return convertEntityToDTO(getService().findPersonById(personId), PersonResponseDTO.class);
    }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponseDTO updatePerson(@PathVariable("personId") Integer personId, @RequestBody PersonResponseDTO personResponseDTO) {
        final Person person = convertDTOToEntity(personResponseDTO, Person.class);

        return convertEntityToDTO(getService().updatePerson(personId, person), PersonResponseDTO.class);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void inactivatePerson(@PathVariable("personId") Integer personId) {
        getService().inactivatePerson(personId);
    }


}


