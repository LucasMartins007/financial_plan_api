package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.service.BillsService;
import com.lucas.github.financial_planning.service.InstallmentService;
import com.lucas.github.financial_planning.service.PersonService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.ListUtil;
import com.lucas.github.financial_planning.utils.Utils;
import com.lucas.github.financial_planning.validators.Validator;
import com.lucas.github.financial_planning.validators.enums.EnumValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillsServiceImpl extends AbstractService<Bills, Integer> implements BillsService {

    private final InstallmentService installmentService;

    @Override
    public Bills registerNewBill(Bills bills, Integer personId) {
        Validator.validate(EnumValidators.BILLS, bills);

        final Person person = getService(PersonService.class).findPersonById(personId);
        bills.setPerson(person);

        resolveInstallments(bills);

        return getRepository().save(bills);
    }

    private void resolveInstallments(Bills bills) {
        if (bills.isSinglePayment()) {
            bills.setNumberInstallments(1);

            final Installment installment = new Installment();
            installment.setValue(bills.getTotalValue());
            installment.setPayed(bills.isPayed());
            installment.setBills(bills);

            getService(InstallmentService.class).registerInstallment(installment);
            bills.setInstallment(List.of(installment));
            return;
        }

        if (ListUtil.isNotNullOrNotEmpty(bills.getInstallment())) {
            bills.getInstallment().forEach(installmentService::registerInstallment);
        }
    }
}
