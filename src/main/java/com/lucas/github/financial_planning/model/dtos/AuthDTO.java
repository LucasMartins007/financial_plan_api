package com.lucas.github.financial_planning.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.github.financial_planning.model.dtos.generic.AbstractDTO;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
public class AuthDTO extends AbstractDTO<Integer> {

    private Integer id;

    private String username;

    private String token;

    private String refreshToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date expirationDate;

    private Integer personId;


}
