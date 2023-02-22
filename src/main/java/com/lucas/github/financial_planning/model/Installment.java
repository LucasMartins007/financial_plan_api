package com.lucas.github.financial_planning.model;

import com.lucas.github.financial_planning.model.generic.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "installment")
public class Installment extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "installmentSeq", sequenceName = "installment_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "is_payed")
    private boolean isPayed;

    @OneToMany(fetch = FetchType.LAZY)
    private Bills bills;

}
