package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String phoneNumber;

    private boolean isMainPhoneNumber;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
