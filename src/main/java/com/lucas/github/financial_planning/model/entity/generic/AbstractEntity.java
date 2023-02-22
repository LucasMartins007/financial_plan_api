package com.lucas.github.financial_planning.model.entity.generic;

import com.lucas.github.financial_planning.model.pattern.AbstractModelClass;
import com.lucas.github.financial_planning.model.pattern.IIdentifier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AbstractEntity<T extends Number> extends AbstractModelClass<T> {

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
