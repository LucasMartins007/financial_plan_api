package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.entity.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String description;

    private boolean isMainEmail;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
