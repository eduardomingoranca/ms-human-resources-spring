package com.brazil.hruser.exceptions;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private int status;
    private String details;
}
