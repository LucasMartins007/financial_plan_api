package com.lucas.github.financial_planning.validators.interfaces;

public interface IValidatorFactory {

    @SuppressWarnings("rawtypes")
    IValidator createValidator();

}
