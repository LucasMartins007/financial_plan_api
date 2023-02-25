package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.repository.BillsRepository;
import com.lucas.github.financial_planning.repository.PersonRepository;
import com.lucas.github.financial_planning.service.PersonService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractService<Person, Integer> implements PersonService {


    @Override
    public String teste(){
        List<Person> persons = getRepository(PersonRepository.class).findAll();

        List<Bills> persons1 = getRepository(BillsRepository.class).findAll();

        return persons.toString();
    }
}
