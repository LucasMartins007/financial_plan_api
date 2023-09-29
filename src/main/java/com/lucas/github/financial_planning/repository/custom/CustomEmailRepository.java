package com.lucas.github.financial_planning.repository.custom;

import com.lucas.github.financial_planning.model.entity.Email;

import java.util.List;
import java.util.Optional;

public interface CustomEmailRepository {

    Optional<Email> findMainEmailByPersonId(Integer personId);

    Optional<Email> findByDescription(String description);


}
