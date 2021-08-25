package com.brazil.hruser.handlers;

import com.brazil.hruser.exceptions.BadRequestException;
import com.brazil.hruser.exceptions.BadRequestExceptionDetails;
import com.brazil.hruser.exceptions.ValidationExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details(badRequestException.getMessage())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        /**
         * recebendo todos os campos com erros */
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        /**
         * recebendo as mensagens */
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Invalid Fields")
                        .details("Check the field(s) error")
                        .fieldsMessage(fieldsMessage)
                        .build(), HttpStatus.BAD_REQUEST);
    }

}
