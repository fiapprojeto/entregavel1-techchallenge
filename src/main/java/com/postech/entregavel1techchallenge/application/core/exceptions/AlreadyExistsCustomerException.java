package com.postech.entregavel1techchallenge.application.core.exceptions;

public class AlreadyExistsCustomerException extends RuntimeException {

    public AlreadyExistsCustomerException(String message) {
        super(message);
    }
}
