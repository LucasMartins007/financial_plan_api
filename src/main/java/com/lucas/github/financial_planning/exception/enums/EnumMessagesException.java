package com.lucas.github.financial_planning.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumMessagesException {

    NULLPOINTER_EXCEPTION(500,"Ocorreu um erro nos nossos servidores, por favor, entre em contato"),

    MISSING_FIELDS_EXCEPTION(400, ""),

    INVALID_USERNAME_OR_PASSWORD(400, "Nome de usuário ou senha inválidos, tente novamente.");

    private final Integer statusCode;
    private final String message;
}
