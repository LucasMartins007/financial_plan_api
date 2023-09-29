package com.lucas.github.financial_planning.repository.specs;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.enums.EnumCategory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Order;

public class BillsSpec {

    private static final String FIELD_ID = "id";

    private static final String FIELD_CATEGORY = "category";

    public static Specification<Bills> byId(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(FIELD_ID), id);
    }

    public static Specification<Bills> byCategory(EnumCategory category) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(FIELD_CATEGORY), category.name());
    }

    public static Specification<Bills> orderBy(boolean isAscending, String field) {
        return (root, query, criteriaBuilder) -> {
            Order order = isAscending ? criteriaBuilder.asc(root.get(field)) : criteriaBuilder.desc(root.get(field));

            return query
                    .distinct(true)
                    .orderBy(order)
                    .getRestriction();
        };
    }


}
