package com.lucas.github.financial_planning.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class PersonDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String name;

    private Integer age;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthDate;

    private List<EmailDTO> email;

    private List<PhoneDTO> phone;

    private List<BillsDTO> bills;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
