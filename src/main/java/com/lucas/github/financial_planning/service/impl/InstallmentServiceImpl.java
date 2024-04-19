package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.repository.InstallmentRepository;
import com.lucas.github.financial_planning.service.InstallmentService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstallmentServiceImpl extends AbstractService<Installment, Integer> implements InstallmentService {

    private final InstallmentRepository installmentRepository;

    @Override
    public Installment registerInstallment(Installment installment) {
        Validator.validate(EnumValidators.INSTALLMENT, installment);

        installment.setIncludeDate(new Date());
        installment.setUpdateDate(new Date());
        installment.setActive(true);

        return getRepository().save(installment);
    }

    @Override
    public void updateInstallment(Installment installment, Integer installmentId) {
        Validator.validate(EnumValidators.INSTALLMENT, installment);

//        getRepository(InstallmentRepository.class)
    }

    @Override
    public List<Installment> findAllInstallmentsByBill(Bills bills) {
        return installmentRepository.findAllByBills(bills);
    }


}
