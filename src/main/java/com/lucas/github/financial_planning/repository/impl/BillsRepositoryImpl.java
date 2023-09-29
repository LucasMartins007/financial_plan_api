package com.lucas.github.financial_planning.repository.impl;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.enums.EnumCategory;
import com.lucas.github.financial_planning.repository.BillsRepository;
import com.lucas.github.financial_planning.repository.custom.CustomBillsRepositoy;
import com.lucas.github.financial_planning.repository.specs.BillsSpec;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BillsRepositoryImpl implements CustomBillsRepositoy {

    private final BillsRepository billsRepository;

    @Override
    public List<Bills> findAllByCategory(EnumCategory category) {
        return billsRepository.findAll(BillsSpec.byCategory(category));
    }
}
