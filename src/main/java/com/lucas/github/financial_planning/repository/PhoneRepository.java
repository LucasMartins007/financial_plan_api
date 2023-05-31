package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    Optional<Phone> findPhoneByPhoneNumber(String phoneNumber);

    @Query(" select p from Phone p " +
            "   where p.person.id = :personId " +
            "   and p.isMainPhoneNumber is true ")
    Phone findMainPhoneByPersonId(Integer personId);
}
