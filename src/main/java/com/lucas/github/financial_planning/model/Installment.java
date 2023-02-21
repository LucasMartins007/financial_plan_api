package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "installment")
public class Installment extends AbstractEntity<Integer> {

    private BigDecimal value;

    private Date paymentDate;

    private boolean isPayed;

}
