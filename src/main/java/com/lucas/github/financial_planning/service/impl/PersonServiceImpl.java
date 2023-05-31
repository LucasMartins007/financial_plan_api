package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.repository.PersonRepository;
import com.lucas.github.financial_planning.service.EmailService;
import com.lucas.github.financial_planning.service.PersonService;
import com.lucas.github.financial_planning.service.PhoneService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractService<Person, Integer> implements PersonService {

    private final PersonRepository personRepository;

    private final EmailService emailService;

    private final PhoneService phoneService;

    @Override
    public Person registerNewPerson(Person person) {
        Validator.validate(EnumValidators.PERSON, person);
        validateDuplicatedCpf(person.getCpfCnpj());

        final Person managedPerson = personRepository.save(person);
        person.getEmails()
                .forEach(email -> emailService.registerEmailForPerson(email, managedPerson.getId()));
        person.getPhones()
                .forEach(phone -> phoneService.registerPhoneForPerson(phone, managedPerson.getId()));

        return managedPerson;
    }

    private void validateDuplicatedCpf(String cpfCnpj) {
        personRepository.findByCpfCnpj(cpfCnpj).ifPresent((person -> {
            throw new DomainRuntimeException(EnumMessagesException.MISSING_FIELDS_EXCEPTION, person.getCpfCnpj());
        }));
    }
}
