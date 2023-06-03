package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.config.anotations.ExcludeFromResponse;
import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String username;

    @ExcludeFromResponse
    private String password;

    private RoleDTO role;

}
