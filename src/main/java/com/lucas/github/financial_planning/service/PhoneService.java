package com.lucas.github.financial_planning.service;

import com.lucas.github.financial_planning.model.entity.Phone;
import com.lucas.github.financial_planning.service.generic.IAbstractService;

import java.util.List;

public interface PhoneService extends IAbstractService {

    Phone registerPhoneForPerson(Phone phone, Integer personId);

    List<Phone> getAllPhonesByPerson(Integer personId);
}
