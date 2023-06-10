package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.validators.generics.RequiredFieldsValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;

public class EmailValidator implements IValidator<Email, Integer> {

    @Override
    public void validate(Email email) {
        validateRequiredFields(email);
        validateEmailFormat(email.getDescription());
    }

    private void validateEmailFormat(String email) {
        final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(regex)) {
            throw new DomainRuntimeException(EnumMessagesException.INVALID_EMAIL, email);
        }
    }

    @Override
    public void validateRequiredFields(Email emai) {
        final RequiredFieldsValidator fieldsValidator = new RequiredFieldsValidator();
        fieldsValidator.verifyField(emai.getDescription(), "Email description");

        fieldsValidator.validate();
    }
}
