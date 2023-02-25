package com.lucas.github.financial_planning.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.github.financial_planning.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Setter
public class DefaultExceptionResponse {

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dateError;

    private Integer status;

    private List<String> missingFields = new ArrayList<>();

    public DefaultExceptionResponse(String message) {
        this.message = replaceInvalidCaracters(message);
    }

    private String replaceInvalidCaracters(String message) {
        if (StringUtil.isNotNullOrEmpty(message)) {
            return message;
        }
        return Pattern.compile("\t")
                .matcher(message.replaceAll("\r\n|\r|\n", "<br/>"))
                .replaceAll("&nbsp;&nbsp;");
    }
}
