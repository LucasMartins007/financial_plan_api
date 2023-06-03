package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

public interface PersonService extends IAbstractService {


    Person registerNewPerson(Person person);

}
