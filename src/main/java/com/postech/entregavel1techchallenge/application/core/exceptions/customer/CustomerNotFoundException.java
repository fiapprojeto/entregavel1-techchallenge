package com.postech.entregavel1techchallenge.application.core.exceptions.customer;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class CustomerNotFoundException extends BaseException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
