package com.postech.entregavel1techchallenge.adapters.in.controller.handler;

import com.postech.entregavel1techchallenge.application.core.exceptions.AlreadyExistsCustomerException;
import com.postech.entregavel1techchallenge.application.core.exceptions.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyExistsCustomerException.class)
    public ResponseEntity handlerAlreadyExistsCustomerException(AlreadyExistsCustomerException e) {
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity handlerCustomerNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }


}
