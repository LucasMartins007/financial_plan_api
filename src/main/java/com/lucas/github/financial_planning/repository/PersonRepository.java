package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Integer findIdByUser(User user);
}
