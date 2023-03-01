package com.lucas.github.financial_planning.exception;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.model.DefaultExceptionResponse;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainRuntimeException.class)
    public ResponseEntity<DefaultExceptionResponse> handleDomainException(DomainRuntimeException exception) {
        final DefaultExceptionResponse defaultExceptionResponse = new DefaultExceptionResponse(exception.getMessage());
        defaultExceptionResponse.setDateError(new Date());
        defaultExceptionResponse.setMissingFields(null);
        defaultExceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return deafultException(defaultExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<DefaultExceptionResponse> handleNullPointerException(Exception exception) {
        final DefaultExceptionResponse defaultExceptionResponse = new DefaultExceptionResponse(EnumMessagesException.NULLPOINTER_EXCEPTION.getMessage());
        defaultExceptionResponse.setDateError(new Date());
        defaultExceptionResponse.setMissingFields(null);
        defaultExceptionResponse.setStatus(EnumMessagesException.NULLPOINTER_EXCEPTION.getStatusCode());

        return deafultException(defaultExceptionResponse, HttpStatus.resolve(EnumMessagesException.NULLPOINTER_EXCEPTION.getStatusCode()));
    }

    private ResponseEntity<DefaultExceptionResponse> deafultException(DefaultExceptionResponse exceptionResponse, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResponse);
    }
    
}
