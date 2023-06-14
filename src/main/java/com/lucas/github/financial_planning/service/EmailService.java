package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.service.generic.IAbstractService;



public interface EmailService extends IAbstractService {

    /**
     * @param email to be registered.
     * @return a saved Email with Id.
     */
    Email registerEmailForPerson(Email email, Integer personId);

    /**
     * @param personId id from the person who own the email
     * @param emailId id of the email
     * @param email to be updated.
     */
    void updateEmail(Integer personId, Integer emailId, Email email);

    /**
     * @param personId id from the person who own the email
     * @param emailId id of the email
     */
    void inactivateEmail(Integer personId, Integer emailId);

    /**
     *
     * @param personId id from the person who own the email
     * @param emailId id of the email
     * @return Email founded
     */
    Email findEmailByPersonAndId(Integer personId, Integer emailId);
}
