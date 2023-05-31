package com.lucas.github.financial_planning.validators.generics;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.utils.ListUtil;
import com.lucas.github.financial_planning.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RequiredFieldsValidator {

    private final List<String> nullFields = new ArrayList<>();

    public void verifyField(Object fieldValue, String fieldName) {
        boolean isNullOrEmpty = fieldValueIsNullOrEmpty(fieldValue);
        if (isNullOrEmpty) {
            nullFields.add(fieldName);
        }
    }

    public void validate() {
        if (ListUtil.isNotNullOrNotEmpty(nullFields)) {
            throw new DomainRuntimeException(EnumMessagesException.MISSING_FIELDS_EXCEPTION, this.nullFields);
        }
    }

    private boolean fieldValueIsNullOrEmpty(Object fieldValue) {
        if (fieldValue instanceof Collection<?>) {
            return ListUtil.isNullOrEmpty((Collection<?>) fieldValue);
        }
        if (fieldValue instanceof CharSequence) {
            return StringUtil.isNullOrEmpty(fieldValue);
        }
        if (fieldValue != null && fieldValue.getClass().isArray()) {
            return ListUtil.isNullOrEmpty((Object[]) fieldValue);
        }
        return fieldValue == null;
    }

}
