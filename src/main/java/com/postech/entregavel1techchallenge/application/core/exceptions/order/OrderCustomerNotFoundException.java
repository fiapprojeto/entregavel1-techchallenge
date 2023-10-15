package com.postech.entregavel1techchallenge.application.core.exceptions.order;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class OrderCustomerNotFoundException extends BaseException {
    public OrderCustomerNotFoundException(String message) {
        super(message);
    }
}
