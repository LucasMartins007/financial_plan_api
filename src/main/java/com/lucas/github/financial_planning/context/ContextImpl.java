package com.lucas.github.financial_planning.context;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;

public class ContextImpl implements ApplicationContextAware {

    private Repositories repositories;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.repositories = new Repositories(applicationContext);
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractEntity<?>, I> JpaRepository<T, I> getRepositoryFromClass(Class<T> domainClass) {
        return (JpaRepository<T, I>) repositories.getRepositoryFor(domainClass)
                .orElseThrow(() -> new RuntimeException(""));
    }


}
