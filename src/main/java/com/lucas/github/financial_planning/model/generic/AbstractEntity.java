package com.lucas.github.financial_planning.model.generic;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AbstractEntity<T extends Number> implements IIdentifier<T>{

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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(id=" + getId() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked") 
        final AbstractEntity<T> other = (AbstractEntity<T>) obj;
        if (this.getId() != null && other.getId() == null) {
            return false;
        }

        if (other.getId() != null && this.getId() == null) {
            return false;
        }

        if (this.getId() == null && other.getId() == null) {
            return false;
        }

        return this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
}
