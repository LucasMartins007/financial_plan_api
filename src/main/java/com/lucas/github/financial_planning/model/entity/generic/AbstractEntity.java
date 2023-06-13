package com.lucas.github.financial_planning.model.entity.generic;

import com.lucas.github.financial_planning.model.pattern.AbstractModelClass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractEntity<T extends Number> extends AbstractModelClass<T> {

    public boolean hasId() {
        return this.getId() != null;
    }

}
