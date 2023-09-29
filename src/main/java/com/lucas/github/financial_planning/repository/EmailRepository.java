package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.repository.custom.CustomEmailRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepository extends JpaSpecificationExecutor<Email>, JpaRepository<Email, Integer>, CustomEmailRepository {


    Optional<Email> findByIdAndPerson(Integer emailId, Person person);

    List<Email> findAllByPerson(Person person);
}
