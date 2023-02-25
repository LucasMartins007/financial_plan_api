package com.lucas.github.financial_planning.exception;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.model.DefaultExceptionResponse;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

@ControllerAdvice
public class DefaultExceptionHandler  {


    @ExceptionHandler(DomainRuntimeException.class)
    public ResponseEntity<DefaultExceptionResponse> handleDomainException(DomainRuntimeException exception) {
        final DefaultExceptionResponse defaultExceptionResponse = new DefaultExceptionResponse(exception.getMessage());
        defaultExceptionResponse.setDateError(new Date());
        defaultExceptionResponse.setMissingFields(null);
        defaultExceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return exception(defaultExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        final List<String> missingFields = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getField)
                .toList();

        final DefaultExceptionResponse defaultExceptionResponse = new DefaultExceptionResponse(EnumMessagesException.MISSING_FIELDS_EXCEPTION.getMessage());
        defaultExceptionResponse.setMissingFields(missingFields);
        defaultExceptionResponse.setDateError(new Date());
        defaultExceptionResponse.setStatus(EnumMessagesException.MISSING_FIELDS_EXCEPTION.getStatusCode());

        return exception(defaultExceptionResponse, HttpStatus.resolve(EnumMessagesException.MISSING_FIELDS_EXCEPTION.getStatusCode()));
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<DefaultExceptionResponse> handleNullPointerException(Exception exception) {
        final DefaultExceptionResponse defaultExceptionResponse = new DefaultExceptionResponse(EnumMessagesException.NULLPOINTER_EXCEPTION.getMessage());
        defaultExceptionResponse.setDateError(new Date());
        defaultExceptionResponse.setMissingFields(null);
        defaultExceptionResponse.setStatus(EnumMessagesException.NULLPOINTER_EXCEPTION.getStatusCode());

        return exception(defaultExceptionResponse, HttpStatus.resolve(EnumMessagesException.NULLPOINTER_EXCEPTION.getStatusCode()));
    }

    private ResponseEntity<DefaultExceptionResponse> exception(DefaultExceptionResponse exceptionResponse, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResponse);
    }
}
