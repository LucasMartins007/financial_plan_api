package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.service.generic.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<S extends IAbstractService> {

    @Autowired
    private S service;

    protected S getService() {
        return service;
    }

}
