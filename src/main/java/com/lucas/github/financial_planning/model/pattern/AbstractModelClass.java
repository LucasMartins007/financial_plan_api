package com.lucas.github.financial_planning.model.pattern;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;

public abstract class AbstractModelClass<T extends Number> implements IIdentifier<Integer> {

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

        @SuppressWarnings("unchecked") final AbstractEntity<T> other = (AbstractEntity<T>) obj;
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
