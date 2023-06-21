package com.lucas.github.financial_planning.controller;

import com.lucas.github.financial_planning.model.dtos.BillsDTO;
import com.lucas.github.financial_planning.model.dtos.InstallmentDTO;
import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.service.BillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(PersonController.PATH + BillsController.PATH)
public class BillsController extends AbstractController<BillsService> {

    public static final String PATH =  "{personId}/bills";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BillsDTO registerBill(@PathVariable("personId") Integer personId, @RequestBody BillsDTO billsDTO){
        final Bills bills = convertDTOToEntity(billsDTO, Bills.class);

        return convertEntityToDTO(getService().registerNewBill(bills, personId), BillsDTO.class);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BillsDTO> listAllBillsFromPerson(@PathVariable("personId") Integer personId) {
        return convertEntityToDTO(getService().findAllBillsFromPerson(personId), BillsDTO.class);
    }

    @GetMapping("{billId}")
    @ResponseStatus(HttpStatus.OK)
    public List<InstallmentDTO> listAllInstallmentsFromBill(@PathVariable("personId") Integer personId, @PathVariable("billId") Integer billId) {
        return convertEntityToDTO(getService().findAllInstallmentsFromBill(personId, billId), InstallmentDTO.class);
    }
}
