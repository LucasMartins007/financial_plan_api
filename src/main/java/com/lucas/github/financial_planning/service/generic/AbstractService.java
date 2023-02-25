package com.lucas.github.financial_planning.service.generic;

import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import com.lucas.github.financial_planning.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractService<E extends AbstractEntity<?>, I extends Number>  {

    @Autowired
    private ApplicationContext applicationContext;

    private final Class<E> entityClass;

    @SuppressWarnings("unchecked")
    protected AbstractService() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    public <T extends JpaRepository<?, ?>> T getRepository(Class<T> repositoryClass) {
        return ContextUtils.getBean(repositoryClass);
    }

    @SuppressWarnings("unchecked")
    public JpaRepository<E, I> getRepository() {
        return ContextUtils.getBean(JpaRepository.class, entityClass);
    }




}
