package com.lucas.github.financial_planning.model.generic;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractEntity {

    @Column(name = "include_date")
    @Temporal(TemporalType.DATE)
    private Date includeDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(name = "active")
    private boolean active;

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
