package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.User;
import com.lucas.github.financial_planning.validators.generics.RequiredFieldsValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;

public class UserValidator implements IValidator<User, Integer> {

    @Override
    public void validate(User user) {
        validateRequiredFields(user);
        validatePassword(user.getPassword());
    }

    private void validatePassword(String password) {
        if (password.length() < 6) {
            throw new DomainRuntimeException(EnumMessagesException.INVALID_PASSWORD, password);
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                throw new DomainRuntimeException(EnumMessagesException.INVALID_PASSWORD, password);
            }
        }
    }

    @Override
    public void validateRequiredFields(User user) {
        final RequiredFieldsValidator validator = new RequiredFieldsValidator();
        validator.verifyField(user.getUsername(), "username");
        validator.verifyField(user.getPassword(), "password");
        validator.verifyField(user.getRole(), "role");

        validator.validate();
    }
}
