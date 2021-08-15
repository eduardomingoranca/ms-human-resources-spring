package com.brazil.hrworker.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@SuperBuilder
public class ExceptionDetails {
    protected String title;
    protected int status;
    protected String details;
}
