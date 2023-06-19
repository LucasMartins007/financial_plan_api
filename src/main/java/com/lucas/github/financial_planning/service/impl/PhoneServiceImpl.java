package com.lucas.github.financial_planning.service.impl;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.entity.Person;
import com.lucas.github.financial_planning.model.entity.Phone;
import com.lucas.github.financial_planning.repository.PhoneRepository;
import com.lucas.github.financial_planning.service.PersonService;
import com.lucas.github.financial_planning.service.PhoneService;
import com.lucas.github.financial_planning.service.generic.AbstractService;
import com.lucas.github.financial_planning.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl extends AbstractService<Phone, Integer> implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public Phone registerPhoneForPerson(Phone phone, Integer personId) {
        verifyDuplicatedPhone(phone.getPhoneNumber());
        verifyMainPhone(phone, personId);

        phone.setIncludeDate(new Date());
        phone.setUpdateDate(new Date());
        phone.setActive(true);

        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> getAllPhonesByPerson(Integer personId) {
        return phoneRepository.findAllPhonesByPerson(personId);
    }

    @Override
    public Phone findPhoneByIdAndPerson(Integer personId, Integer phoneId) {
        final Person person = getService(PersonService.class).findPersonById(personId);

        return phoneRepository.findByIdAndPerson(phoneId, person)
                .orElseThrow(() -> new DomainRuntimeException(EnumMessagesException.PHONE_NOT_FOUND, phoneId));
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
        phoneRepository.findByPhoneNumber(phoneNumber)
                .ifPresent(managedPhone -> {
                    throw new DomainRuntimeException(EnumMessagesException.DUPLICATED_PHONE, managedPhone.getPhoneNumber());
                });
    }
}
