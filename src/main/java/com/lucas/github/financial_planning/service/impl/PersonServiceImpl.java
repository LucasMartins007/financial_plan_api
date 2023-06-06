package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.repository.PersonRepository;
import com.lucas.github.financial_planning.service.PersonService;
import com.lucas.github.financial_planning.service.UserService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractService<Person, Integer> implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person registerNewPerson(Person person) {
        Validator.validate(EnumValidators.PERSON, person);
        validateDuplicatedCpf(person.getCpfCnpj());
        person.setIncludeDate(new Date());
        person.setUpdateDate(new Date());
        person.setActive(true);

        final User user = getService(UserService.class).registerNewUser(person.getUser());
        person.setUser(user);

        return personRepository.save(person);
    }

    @Override
    public Person findPersonById(Integer personId) {
        return getRepository().findById(personId)
                .orElseThrow(() -> new DomainRuntimeException(EnumMessagesException.PERSON_NOT_FOUND, personId));
    }

    @Override
    public Person updatePerson(Integer personId, Person person) {
        Validator.validate(EnumValidators.PERSON, person);

        final Person managedPerson = findPersonById(personId);
        person.setId(managedPerson.getId());
        person.setUpdateDate(new Date());
        person.setCpfCnpj(managedPerson.getCpfCnpj());
        person.setUser(managedPerson.getUser());

        return getRepository().save(person);
    }

    @Override
    public void inactivatePerson(Integer personId) {
        final Person person = findPersonById(personId);

        person.setActive(false);

        getRepository().save(person);
    }

    private void validateDuplicatedCpf(String cpfCnpj) {
        personRepository.findByCpfCnpj(cpfCnpj).ifPresent((person -> {
            throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_CPF_CNPJ, person.getCpfCnpj());
        }));
    }
}
