package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.repository.EmailRepository;
import com.lucas.github.financial_planning.service.EmailService;
import com.lucas.github.financial_planning.service.PersonService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.Utils;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl extends AbstractService<Email, Integer> implements EmailService {

    private EmailRepository emailRepository;

    @Override
    public Email registerEmailForPerson(Email email, Integer personId) {
        Validator.validate(EnumValidators.EMAIL, email);
        verifyDuplicatedEmail(email);
        verifyMainEmail(email, personId);

        return emailRepository.save(email);
    }

    @Override
    public void updateEmail(Integer personId, Integer emailId, Email email) {
        Validator.validate(EnumValidators.EMAIL, email);

        final Email managedEmail = findById(emailId);
        final Person person = getService(PersonService.class).findPersonById(personId);
        email.setId(managedEmail.getId());
        email.setActive(true);
        email.setPerson(person);
        email.setUpdateDate(new Date());

        verifyMainEmail(email, personId);
        verifyDuplicatedEmail(email);


        emailRepository.save(email);
    }

    @Override
    public void inactivateEmail(Integer personId, Integer emailId) {
        final Email email = findById(emailId);
        if (email.isMainEmail()) {
            throw new DomainRuntimeException(EnumMessagesException.MAIN_EMAIL_CANNOT_BE_DELETED, email.getDescription());
        }
        final Person person = getService(PersonService.class).findPersonById(personId);
        if (!email.getPerson().equals(person)) {
            throw new DomainRuntimeException(EnumMessagesException.EMAIL_NOT_FROM_PERSON, email.getDescription(), person.getId());
        }

        email.setActive(false);
        email.setUpdateDate(new Date());
        getRepository().save(email);
    }

    public Email findById(Integer emailId) {
        return getRepository().findById(emailId)
                .orElseThrow(() -> new DomainRuntimeException(EnumMessagesException.EMAIL_NOT_FOUND, emailId));
    }

    private void verifyMainEmail(Email email, Integer personId) {
        final Email mainEmail = emailRepository.findMainEmailByPersonId(personId);
        if (Utils.isEmpty(mainEmail) && !email.isMainEmail()) {
            email.setMainEmail(true);
            return;
        }
        if (Utils.isNotEmpty(mainEmail) && email.isMainEmail()) {
            throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_MAIN_EMAIL);
        }
    }

    private void verifyDuplicatedEmail(Email email) {
        emailRepository.findByDescription(email.getDescription())
                .ifPresent(managedEmail -> {
                    if (Utils.isEmpty(managedEmail)) {
                        return;
                    }
                    if (!isUpdate(email)) {
                        throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_EMAIL, managedEmail.getDescription());
                    }
                    if (isUpdate(email) && !managedEmail.getId().equals(email.getId())) {
                        throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_EMAIL, managedEmail.getDescription());
                    }
                });
    }

    private boolean isUpdate(Email email) {
        return email.hasId();
    }
}
