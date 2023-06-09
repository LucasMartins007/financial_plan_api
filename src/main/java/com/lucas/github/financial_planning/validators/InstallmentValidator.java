package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.validators.generics.RequiredFieldsValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InstallmentValidator implements IValidator<Installment, Integer> {

    @Override
    public void validate(Installment installment) {
        validateRequiredFields(installment);
    }

    @Override
    public void validateRequiredFields(Installment installment) {
        final RequiredFieldsValidator fieldsValidator = new RequiredFieldsValidator();
        fieldsValidator.verifyField(installment.getValue(), "Installment value");
        fieldsValidator.verifyField(installment.getBills(), "Referece bill");

        fieldsValidator.validate();
    }
}
