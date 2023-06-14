package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.EmailDTO;
import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PersonController.PATH + EmailController.PATH)
@RequiredArgsConstructor
public class EmailController extends AbstractController<EmailService> {

    public static final String PATH = "{personId}/email";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmailDTO registerNewEmail(@PathVariable("{personId}") Integer personId, @RequestBody EmailDTO emailDTO) {
        final Email email = getService().registerEmailForPerson(convertDTOToEntity(emailDTO, Email.class), personId);

        return convertEntityToDTO(email, EmailDTO.class);
    }

    @PutMapping("/{emailId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmail(@PathVariable("{personId}") Integer personId, @PathVariable("{emailId}") Integer emailId, @RequestBody EmailDTO emailDTO) {
        getService().updateEmail(personId, emailId, convertDTOToEntity(emailDTO, Email.class));
    }

    @DeleteMapping("/{emailId}")
    @ResponseStatus(HttpStatus.OK)
    public void inactivateEmail(@PathVariable("{personId}") Integer personId, @PathVariable("{emailId}") Integer emailId) {
        getService().inactivateEmail(personId, emailId);
    }

    @GetMapping("/{emailId}")
    @ResponseStatus(HttpStatus.OK)
    public EmailDTO getEmailById(@PathVariable("{personId}") Integer personId, @PathVariable("{emailId}") Integer emailId) {
        final Email email = getService().findEmailByPersonAndId(personId, emailId);

        return convertEntityToDTO(email, EmailDTO.class);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmailDTO> getEmailById(@PathVariable("{personId}") Integer personId) {
        final List<Email> emails = getService().findAllEmailByPerson(personId);

        return convertEntityToDTO(emails, EmailDTO.class);

    }


}
