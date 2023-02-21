package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.enums.EnumCategory;
import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bills")
public class Bills extends AbstractEntity<Integer> {

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

}
