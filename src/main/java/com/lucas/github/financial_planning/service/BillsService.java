package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

import java.util.List;

public interface BillsService extends IAbstractService {
    Bills registerNewBill(Bills bills, Integer personId);

    List<Installment> findAllInstallmentsFromBill(Integer personId, Integer billId);
}
