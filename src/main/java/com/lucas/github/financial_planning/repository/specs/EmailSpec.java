package com.lucas.github.financial_planning.repository.specs;

import com.lucas.github.financial_planning.model.entity.Email;
import org.springframework.data.jpa.domain.Specification;

public class EmailSpec {

    private static final String FIELD_DESCRIPTION = "description";

    private static final String FIELD_MAIN_EMAIL = "isMainEmail";

    private static final String FIELD_PERSON = "person";

    private static final String FIELD_ID = "id";

    public static Specification<Email> byDescription(String description) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(FIELD_DESCRIPTION), description);
    }

    public static Specification<Email> byPersonId(Integer personId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(FIELD_PERSON).get(FIELD_ID), personId);
    }

    public static Specification<Email> mainEmail() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isTrue(root.get(FIELD_MAIN_EMAIL));
    }
}
