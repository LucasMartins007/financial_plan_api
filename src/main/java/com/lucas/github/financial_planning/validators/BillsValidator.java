package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.validators.generics.RequiredFieldsValidator;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BillsValidator implements IValidator<Bills, Integer> {

    @Override
    public void validate(Bills bills) {
        validateRequiredFields(bills);
    }

    @Override
    public void validateRequiredFields(Bills bills) {
        final RequiredFieldsValidator fieldsValidator = new RequiredFieldsValidator();
        fieldsValidator.verifyField(bills.getCategory(), "Category");
        fieldsValidator.verifyField(bills.getDescription(), "Description");
        fieldsValidator.verifyField(bills.getPerson(), "Person");
        fieldsValidator.validate();
    }
}
