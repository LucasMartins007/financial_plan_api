package com.lucas.github.financial_planning.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumMessagesException {

    NULLPOINTER_EXCEPTION(500,"An error has ocurred, please try again in a few seconds."),

    MISSING_FIELDS_EXCEPTION(400, ""),

    INVALID_USERNAME_OR_PASSWORD(400, "Invalid username."),

    MISSING_TOKEN(403, "Missing Token."),

    INVALID_TOKEN(403, "Invalid Token."),

    USER_NOT_FOUND(404, "User not found.");

    private final Integer statusCode;
    private final String message;
}
