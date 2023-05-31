package com.lucas.github.financial_planning.validators.interfaces;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;


public interface IValidator<T extends AbstractEntity<I>, I extends Number> {

    void validate(T entityClass);

    void validateRequiredFields(T entityClass);

}
