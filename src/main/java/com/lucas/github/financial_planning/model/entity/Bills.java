package com.lucas.github.financial_planning.model.entity;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import com.lucas.github.financial_planning.model.enums.EnumCategory;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bills")
@EqualsAndHashCode(callSuper = true)
public class Bills extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bills_id_gen")
    @SequenceGenerator(name = "bills_seq", sequenceName = "bills_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "large_description")
    private String largeDescription;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "is_single_payment")
    private boolean isSinglePayment;

    @OneToMany(mappedBy = "bills", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Installment> installment;

    @Column(name = "number_installments")
    private Integer numberInstallments;

    @Column(name = "category")
    private EnumCategory category;

    @Column(name = "is_payed")
    private boolean isPayed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bills_to_person"))
    private Person person;

    @Column(name = "include_date")
    @Temporal(TemporalType.DATE)
    private Date includeDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(name = "active")
    private boolean active;

}
