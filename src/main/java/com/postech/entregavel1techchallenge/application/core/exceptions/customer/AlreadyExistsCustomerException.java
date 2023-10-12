package com.postech.entregavel1techchallenge.application.core.exceptions.customer;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class AlreadyExistsCustomerException extends BaseException {

    public AlreadyExistsCustomerException(String message) {
        super(message);
    }
}
