package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.validators.generics.RequiredFieldsValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator implements IValidator<Person, Integer> {

    @Override
    public void validate(Person person) {
        validateRequiredFields(person);
        CpfCnpjValidator.validate(person.getCpfCnpj());
    }

    @Override
    public void validateRequiredFields(Person person) {
        final RequiredFieldsValidator validator = new RequiredFieldsValidator();
        validator.verifyField(person.getName(), "name");
        validator.verifyField(person.getEmails(), "email");
        validator.verifyField(person.getPhones(), "phone");
        validator.verifyField(person.getCpfCnpj(), "cpfCnpj");

        validator.validate();
    }

}
