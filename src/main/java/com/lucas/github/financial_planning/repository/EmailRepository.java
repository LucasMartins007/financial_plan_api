package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    Optional<Email> findByDescription(String description);

    @Query(" select e from Email e " +
            "   where e.person.id = :personId " +
            "   and e.isMainEmail is true ")
    Email findMainEmailByPersonId(@Param("personId") Integer personId);
}
