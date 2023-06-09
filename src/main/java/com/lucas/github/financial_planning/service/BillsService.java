package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

public interface BillsService extends IAbstractService {
    Bills registerNewBill(Bills bills, Integer personId);
}
