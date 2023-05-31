package com.lucas.github.financial_planning.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumMessagesException {

    NULLPOINTER_EXCEPTION(500, "An error has ocurred, please try again in a few seconds."),

    DUPLICATED_EMAIL(400, "The email {0} already exists."),

    DUPLICATED_PHONE(400, "The phone {0} already exists."),

    DUPLICATED_MAIN_EMAIL(400, "You cannot have more than one main email."),

    DUPLICATED_MAIN_PHONE(400, "You cannot have more than one main phone."),


    INVALID_USERNAME_OR_PASSWORD(400, "Invalid username."),

    INVALID_CPF_CNPJ(400, "Cpf/cnpj {0} is invalid."),

    DUPLICATED_CPF_CNPJ(400, "This cpf/cnpj already exists."),

    MISSING_FIELDS_EXCEPTION(400, "Os seguintes campos são de preenchimento obrigatório: "),

    MISSING_TOKEN(403, "Missing Token."),

    INVALID_TOKEN(403, "Invalid Token."),

    USER_NOT_FOUND(404, "User not found."),

    ;
    private final Integer statusCode;
    private final String message;
}
