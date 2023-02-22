package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.enums.EnumRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO extends AbstractDTO<Integer> {

    private Integer id;

    private EnumRole roleDescription;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
