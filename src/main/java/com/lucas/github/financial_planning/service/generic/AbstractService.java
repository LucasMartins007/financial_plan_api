package com.lucas.github.financial_planning.service.generic;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;

public abstract class AbstractService<E extends AbstractEntity<?>, I extends Number> {

    private Class<E> entityClass;

    private Repositories repositories;

    protected JpaRepository<E, I> getRepository() {
        return this.getRepository(entityClass);
    }

    @SuppressWarnings("unchecked")
    private <T extends AbstractEntity<?>> JpaRepository<T, I> getRepository(Class<E> domainClass) {
        return (JpaRepository<T, I>) repositories.getRepositoryFor(domainClass)
                .orElseThrow(() -> new RuntimeException(""));
    }
}
