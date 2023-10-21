package com.postech.entregavel1techchallenge.application.core.exceptions.order;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class OrderProductNotFoundException extends BaseException {
    public OrderProductNotFoundException(String message) {
        super(message);
    }
}
