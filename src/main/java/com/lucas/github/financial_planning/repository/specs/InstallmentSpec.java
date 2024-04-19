package com.lucas.github.financial_planning.repository.specs;

import com.lucas.github.financial_planning.model.entity.Installment;
import org.springframework.data.jpa.domain.Specification;
import org.yaml.snakeyaml.events.Event;

public class InstallmentSpec {

    private final static String FIELD_ID = "id";

    public static Specification<Installment> byId(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(FIELD_ID), id);
    }
}
