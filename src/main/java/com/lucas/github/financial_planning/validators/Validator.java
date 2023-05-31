package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import com.lucas.github.financial_planning.validators.interfaces.IValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validator {

    public static <T extends AbstractEntity<I>, I extends Number> void validate(EnumValidators enumValidators, T entityClass) {
        final IValidator<T, I> validator = enumValidators.createValidator();
        validator.validate(entityClass);
    }


}
