package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class PhoneDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String phoneNumber;

    private boolean isMainPhoneNumber;

}
