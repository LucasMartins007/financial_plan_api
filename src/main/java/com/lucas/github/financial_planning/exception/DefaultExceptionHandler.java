package com.lucas.github.financial_planning.exception;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.model.DefaultExceptionResponse;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import jakarta.annotation.Priority;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

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

    @Override
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        final List<String> missingFields = ex.getBindingResult().getFieldErrors().stream()
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

        return deafultException(defaultExceptionResponse, HttpStatus.resolve(EnumMessagesException.NULLPOINTER_EXCEPTION.getStatusCode()));
    }

    private ResponseEntity<DefaultExceptionResponse> deafultException(DefaultExceptionResponse exceptionResponse, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResponse);
    }

    private ResponseEntity<Object> exception(DefaultExceptionResponse exceptionResponse, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResponse);
    }
}
