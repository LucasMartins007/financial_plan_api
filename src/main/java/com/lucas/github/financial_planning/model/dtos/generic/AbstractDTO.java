package com.lucas.github.financial_planning.model.dtos.generic;

import com.lucas.github.financial_planning.model.pattern.AbstractModelClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDTO<T extends Number> extends AbstractModelClass<T> {


}
