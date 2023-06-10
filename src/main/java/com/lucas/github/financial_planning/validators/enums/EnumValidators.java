package com.lucas.github.financial_planning.validators.enums;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import com.lucas.github.financial_planning.validators.*;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidatorFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumValidators {

    PERSON(PersonValidator::new),
    USER(UserValidator::new),
    BILLS(BillsValidator::new),
    INSTALLMENT(InstallmentValidator::new),
    EMAIL(EmailValidator::new);

    private final IValidatorFactory iValidatorFactory;

    @SuppressWarnings("unchecked")
    public <T extends AbstractEntity<I>, I extends Number> IValidator<T, I> createValidator() {
        return iValidatorFactory.createValidator();
    }

}
