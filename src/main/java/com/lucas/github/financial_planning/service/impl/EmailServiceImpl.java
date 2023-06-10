package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.repository.EmailRepository;
import com.lucas.github.financial_planning.service.EmailService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.Utils;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl extends AbstractService<Email, Integer> implements EmailService {

    private EmailRepository emailRepository;

    @Override
    public Email registerEmailForPerson(Email email, Integer personId) {
        Validator.validate(EnumValidators.EMAIL, email);
        verifyDuplicatedEmail(email.getDescription());
        verifyMainEmail(email, personId);

        return emailRepository.save(email);
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

    private void verifyDuplicatedEmail(String description) {
        emailRepository.findByDescription(description)
                .ifPresent(managedEmail -> {
                    throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_EMAIL, managedEmail.getDescription());
                });
    }
}
