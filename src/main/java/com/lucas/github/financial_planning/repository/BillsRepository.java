package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillsRepository extends JpaRepository<Bills, Integer> {

    List<Bills> findAllByPerson(Person person);

}
