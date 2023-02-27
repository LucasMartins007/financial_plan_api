package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.entity.Person;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Test extends AbstractDTO<Integer> {


    @NotNull(message = "id must not be nulll")
    private Integer id;

    @NotBlank
    private String arroz;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
