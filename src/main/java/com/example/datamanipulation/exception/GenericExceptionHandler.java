package com.example.datamanipulation.exception;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value = {UniqueConstraintException.class})
    protected ResponseEntity<ErrorRequestBuilder> handleMismatchedInputException(UniqueConstraintException ex) {
        String exceptionMessage = ex.getMessage();

        ErrorRequestBuilder errorRequestBuilder =
                new ErrorRequestBuilder(new Date(), HttpStatus.BAD_REQUEST, exceptionMessage, HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorRequestBuilder, errorRequestBuilder.getError());
    }
}
