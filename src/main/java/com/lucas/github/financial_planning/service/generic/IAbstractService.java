package com.lucas.github.financial_planning.service.generic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbstractService {

    <T extends JpaRepository<?, ?>> T getRepository(Class<T> repositoryClass);

    <T extends IAbstractService> T getService(Class<T> serviceClass);

    JpaRepository getRepository();

}
