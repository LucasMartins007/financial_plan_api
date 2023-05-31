package com.lucas.github.financial_planning.exception.runtime;

import com.lucas.github.financial_planning.exception.MessageExceptionFormatter;
import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DomainRuntimeException extends RuntimeException {

    public DomainRuntimeException() {
    }

    public DomainRuntimeException(String message) {
        super(message);
    }

    public DomainRuntimeException(EnumMessagesException enumMessagesException) {
        super(enumMessagesException.getMessage());
    }

    public DomainRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainRuntimeException(String message, Object... arguments) {
        this(MessageExceptionFormatter.getMessage(message, arguments));
    }

    public DomainRuntimeException(EnumMessagesException enumMessagesException, Object... arguments) {
        this(MessageExceptionFormatter.getMessage(enumMessagesException.getMessage(), arguments));
    }





}
