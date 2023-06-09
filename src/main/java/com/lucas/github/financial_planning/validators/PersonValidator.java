package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.validators.generics.RequiredFieldsValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
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
        validator.verifyField(person.getCpfCnpj(), "cpfCnpj");

        validator.validate();
    }

}
