package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.entity.Bills;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class InstallmentDTO extends AbstractDTO<Integer> {

    private Integer id;

    private BigDecimal value;

    private Date paymentDate;

    private boolean isPayed;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
