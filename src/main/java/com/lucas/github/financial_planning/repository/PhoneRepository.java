package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    Optional<Phone> findByPhoneNumber(String phoneNumber);

    Optional<Phone> findByIdAndPerson(Integer phoneId, Person person);

    @Query(" select p from Phone p " +
            "   where p.person.id = :personId " +
            "   and p.isMainPhoneNumber is true ")
    Phone findMainPhoneByPersonId(Integer personId);

    @Query(" select p from Phone p " +
            "   where p.person.id = :personId " +
            "   and p.active is true ")
    List<Phone> findAllPhonesByPerson(Integer personId);
}
