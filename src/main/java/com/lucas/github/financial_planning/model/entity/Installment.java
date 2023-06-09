package com.lucas.github.financial_planning.model.entity;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "installment")
@EqualsAndHashCode(callSuper = true)
public class Installment extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "installment_id_gen")
    @SequenceGenerator(name = "installment_seq", sequenceName = "installment_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "is_payed")
    private boolean isPayed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bills_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_installment_to_bills"))
    private Bills bills;

    @Column(name = "include_date")
    @Temporal(TemporalType.DATE)
    private Date includeDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(name = "active")
    private boolean active;

}
