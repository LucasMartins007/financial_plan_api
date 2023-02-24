package com.lucas.github.financial_planning.context;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContext {

    IContext context = new ContextImpl();

    <T extends AbstractEntity<?>, I> JpaRepository<T, I> getRepositoryFromClass(Class<T> domainClass);

    static IContext context() {
        return context;
    }

    void createBean(Class<?> domainClass);
}
