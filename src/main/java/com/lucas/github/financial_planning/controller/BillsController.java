package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.BillsDTO;
import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.service.BillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PersonController.PATH + BillsController.PATH)
public class BillsController extends AbstractController<BillsService> {

    public static final String PATH =  "{personId}/bills";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BillsDTO registerBill(@PathVariable("{personId}") Integer personId, @RequestBody BillsDTO billsDTO){
        final Bills bills = convertDTOToEntity(billsDTO, Bills.class);

        return convertEntityToDTO(getService().registerNewBill(bills, personId), BillsDTO.class);
    }
}
