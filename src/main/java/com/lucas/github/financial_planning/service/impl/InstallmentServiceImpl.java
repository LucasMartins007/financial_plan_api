package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.service.InstallmentService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class InstallmentServiceImpl extends AbstractService<Installment, Integer> implements InstallmentService {

    @Override
    public Installment registerInstallment(Installment installment) {
        Validator.validate(EnumValidators.INSTALLMENT, installment);

        installment.setIncludeDate(new Date());
        installment.setUpdateDate(new Date());
        installment.setActive(true);

        return getRepository().save(installment);
    }


}
