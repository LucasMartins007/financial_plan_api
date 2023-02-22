package com.lucas.github.financial_planning.model.entity;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "installment")
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
