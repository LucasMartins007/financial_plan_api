package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import com.lucas.github.financial_planning.model.entity.generic.AbstractEntity;
import com.lucas.github.financial_planning.service.generic.IAbstractService;
import com.lucas.github.financial_planning.utils.ListUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractController<S extends IAbstractService> {

    @Autowired
    private S service;

    @Autowired
    private ModelMapper mapper;

    protected S getService() {
        return service;
    }

    protected <D extends AbstractDTO<?>, C extends AbstractEntity<?>> C convertDTOToEntity(D dtoClass, Class<C> entityClass) {
        return mapper.map(dtoClass, entityClass);
    }

    protected <D extends AbstractDTO<?>, C extends AbstractEntity<?>> D convertEntityToDTO(C entityClass, Class<D> dtoClass) {
        return mapper.map(entityClass, dtoClass);
    }

    protected <D extends AbstractDTO<?>, C extends AbstractEntity<?>> List<D> convertEntityToDTO(List<C> entityClass, Class<D> dtoClass) {
        return ListUtil.stream(entityClass)
                .map(d -> mapper.map(entityClass, dtoClass))
                .toList();
    }

    protected <D extends AbstractDTO<?>, C extends AbstractEntity<?>> List<C> convertDTOToEntity(List<D> dtoClasses, Class<C> entityClass) {
        return ListUtil.stream(dtoClasses)
                .map(d -> mapper.map(d, entityClass))
                .toList();
    }
}
