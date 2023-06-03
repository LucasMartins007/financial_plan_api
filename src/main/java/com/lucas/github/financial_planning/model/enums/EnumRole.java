package com.lucas.github.financial_planning.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumRole {

    USER("User"),
    ADMIN("Admin");

    private final String description;

}
