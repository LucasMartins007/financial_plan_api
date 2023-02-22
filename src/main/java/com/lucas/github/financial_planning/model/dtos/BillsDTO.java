package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.model.enums.EnumCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BillsDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String description;

    private String largeDescription;

    private Date startDate;

    private Date endDate;

    private BigDecimal totalValue;

    private boolean isSinglePayment;

    private List<Installment> installment;

    private Integer numberInstallments;

    private EnumCategory category;

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
