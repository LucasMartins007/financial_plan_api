package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.PhoneDTO;
import com.lucas.github.financial_planning.model.entity.Phone;
import com.lucas.github.financial_planning.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(PersonController.PATH + PhoneController.PATH)
public class PhoneController extends AbstractController<PhoneService> {

    public static final String PATH = "{personId}/phone";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneDTO registerPhone(@PathVariable("{personId}") Integer personId, @RequestBody PhoneDTO phoneDTO) {
        final Phone phone = convertDTOToEntity(phoneDTO, Phone.class);

        return convertEntityToDTO(getService().registerPhoneForPerson(phone, personId), PhoneDTO.class);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PhoneDTO> getAllPhonesByPerson(@PathVariable("{personId}") Integer personId) {
        return convertEntityToDTO(getService().getAllPhonesByPerson(personId), PhoneDTO.class);
    }
}
