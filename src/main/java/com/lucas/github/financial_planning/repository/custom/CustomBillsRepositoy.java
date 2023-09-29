package com.lucas.github.financial_planning.repository.custom;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.enums.EnumCategory;

import java.util.List;

public interface CustomBillsRepositoy {

    List<Bills> findAllByCategory(EnumCategory category);

}
