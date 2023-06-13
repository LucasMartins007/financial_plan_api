package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.service.generic.IAbstractService;



public interface EmailService extends IAbstractService {

    /**
     * @param email to be registered.
     * @return a saved Email with Id.
     */
    Email registerEmailForPerson(Email email, Integer personId);

    void updateEmail(Integer personId, Integer emailId, Email email);
}
