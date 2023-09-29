package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.repository.custom.CustomBillsRepositoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillsRepository extends JpaSpecificationExecutor<Bills>, JpaRepository<Bills, Integer>, CustomBillsRepositoy {

    List<Bills> findAllByPerson(Person person);

}
