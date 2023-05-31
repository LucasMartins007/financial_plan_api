package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Phone;
import com.lucas.github.financial_planning.repository.PhoneRepository;
import com.lucas.github.financial_planning.service.PhoneService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl extends AbstractService<Phone, Integer> implements PhoneService {

    private final PhoneRepository phoneRepository;


    @Override
    public Phone registerPhoneForPerson(Phone phone, Integer personId) {
        verifyDuplicatedPhone(phone.getPhoneNumber());
        verifyMainPhone(phone, personId);

        return phoneRepository.save(phone);
    }

    private void verifyMainPhone(Phone phone, Integer personId) {
        final Phone mainPhone = phoneRepository.findMainPhoneByPersonId(personId);
        if (Utils.isEmpty(mainPhone) && !phone.isMainPhoneNumber()) {
            phone.setMainPhoneNumber(true);
            return;
        }
        if (Utils.isNotEmpty(mainPhone) && phone.isMainPhoneNumber()) {
            throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_MAIN_PHONE);
        }
    }

    private void verifyDuplicatedPhone(String phoneNumber) {
        phoneRepository.findPhoneByPhoneNumber(phoneNumber)
                .ifPresent(managedPhone -> {
                    throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_PHONE, managedPhone.getPhoneNumber());
                });
    }
}
