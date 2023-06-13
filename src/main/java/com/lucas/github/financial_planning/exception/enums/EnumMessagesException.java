package com.lucas.github.financial_planning.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumMessagesException {

    NULLPOINTER_EXCEPTION(500, "An error has ocurred, please try again in a few seconds."),

    FAILED_TO_CREATE_CLASS_INSTANCE(500, "Failed to create an instance for {0} class, stackTrace: {1}"),

    DUPLICATED_EMAIL(400, "The email {0} already exists."),

    DUPLICATED_PHONE(400, "The phone {0} already exists."),

    DUPLICATED_MAIN_EMAIL(400, "You cannot have more than one main email."),

    DUPLICATED_MAIN_PHONE(400, "You cannot have more than one main phone."),

    DUPLICATED_USERNAME(400, "This username already exists, please try other"),

    DUPLICATED_CPF_CNPJ(400, "The cpf/cnpj {0} already exists."),

    INVALID_USERNAME_OR_PASSWORD(400, "Invalid username."),

    INVALID_CPF_CNPJ(400, "Cpf/cnpj {0} is invalid."),

    MISSING_FIELDS_EXCEPTION(400, "The field {0} is mandatory."),

    MISSING_TOKEN(403, "Missing Token."),

    INVALID_TOKEN(403, "Invalid Token."),

    USER_NOT_FOUND(404, "User not found."),

    INVALID_PASSWORD(400, "The password should have at least 6 characters and be alphaNumeric. "),

    ROLE_NOT_FOUND(400, "Role {0} doesn't exists."),

    PERSON_NOT_FOUND(400, "The person {0} does not exists."),

    INVALID_EMAIL(400, "The email {0} is invalid."),

    EMAIL_NOT_FOUND(400, "The email {0} does not exist.");

    private final Integer statusCode;

    private final String message;
}
