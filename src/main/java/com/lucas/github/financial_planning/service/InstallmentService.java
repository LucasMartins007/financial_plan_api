package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

import java.util.List;

public interface InstallmentService extends IAbstractService  {

    Installment registerInstallment(Installment installment);

    List<Installment> findAllInstallmentsByBill(Bills bills);

}
