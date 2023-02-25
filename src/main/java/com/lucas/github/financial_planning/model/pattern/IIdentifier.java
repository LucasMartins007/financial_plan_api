package com.lucas.github.financial_planning.model.pattern;

import java.io.Serializable;

public interface IIdentifier<T extends Number> extends Serializable {

    T getId();
}
