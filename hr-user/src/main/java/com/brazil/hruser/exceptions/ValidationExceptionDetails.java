package com.brazil.hruser.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {
    private final String fieldsMessage;
}
