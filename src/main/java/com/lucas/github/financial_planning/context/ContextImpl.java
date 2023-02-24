package com.lucas.github.financial_planning.context;

import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;


public class ContextImpl implements ApplicationContextAware, IContext {

    private Repositories repositories;

    private ApplicationContext applicationContext;

    @Override
    @SuppressWarnings("NullableProblems")
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.repositories = new Repositories(applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends AbstractEntity<?>, I> JpaRepository<T, I> getRepositoryFromClass(Class<T> domainClass) {
        return (JpaRepository<T, I>) repositories.getRepositoryFor(domainClass)
                .orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public void createBean(Class<?> domainClass) {
        try {
            final ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
            final DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

            if (!beanFactory.containsBean(domainClass.getSimpleName())) {
                final GenericBeanDefinition generatorBean = new GenericBeanDefinition();
                generatorBean.setBeanClass(domainClass);
                generatorBean.setLazyInit(true);

                defaultListableBeanFactory.registerBeanDefinition(domainClass.getSimpleName(), generatorBean);
            }
        } catch (IllegalStateException | BeanDefinitionStoreException e) {
            throw new DomainRuntimeException(e.getMessage());
        }
    }


}
