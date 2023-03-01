package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class InstallmentDTO extends AbstractDTO<Integer> {

    private Integer id;

    private BigDecimal value;

    private Date paymentDate;

    private boolean isPayed;

}
