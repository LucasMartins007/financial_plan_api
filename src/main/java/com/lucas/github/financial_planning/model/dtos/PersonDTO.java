package com.lucas.github.financial_planning.model.dtos;

import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class PersonDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String name;

    private Integer age;

    private String cpfCnpj;

    private UserDTO user;

    private List<EmailDTO> emails;

    private List<PhoneDTO> phones;

    private List<BillsDTO> bills;

}
