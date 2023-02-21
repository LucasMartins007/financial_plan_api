package com.lucas.github.financial_planning.model.generic;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractEntity<E extends Number> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "personSeq", sequenceName = "person_sequence", allocationSize = 1)
    protected E id;

    @Column(name = "include_date")
    @Temporal(TemporalType.DATE)
    protected Date includeDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    protected Date updateDate;

    @Column(name = "active")
    protected boolean active;

    @PrePersist
    void preInsert() {
        this.includeDate = new Date();
        this.updateDate = new Date();
        this.active = true;
    }

    @PreUpdate
    void preUpdate() {
        this.updateDate = new Date();
    }

}
