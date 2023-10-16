package com.postech.entregavel1techchallenge.application.core.exceptions.order;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class OrderNotFoundException extends BaseException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
