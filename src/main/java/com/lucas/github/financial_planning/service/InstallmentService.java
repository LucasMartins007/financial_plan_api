package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

public interface InstallmentService extends IAbstractService  {

    Installment registerInstallment(Installment installment);

}
