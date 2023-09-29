package com.lucas.github.financial_planning.repository.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Email;
import com.lucas.github.financial_planning.repository.EmailRepository;
import com.lucas.github.financial_planning.repository.custom.CustomEmailRepository;
import com.lucas.github.financial_planning.repository.specs.EmailSpec;
import lombok.AllArgsConstructor;

import java.util.Optional;

import static com.lucas.github.financial_planning.repository.specs.EmailSpec.*;

@AllArgsConstructor
public class EmailRepositoryImpl implements CustomEmailRepository {

    private final EmailRepository emailRepository;

    @Override
    public Optional<Email> findMainEmailByPersonId(Integer personId) {
        return emailRepository.findOne(mainEmail().and(byPersonId(personId)));
    }

    @Override
    public Optional<Email> findByDescription(String description) {
        return emailRepository.findOne(byDescription(description));
    }
}
