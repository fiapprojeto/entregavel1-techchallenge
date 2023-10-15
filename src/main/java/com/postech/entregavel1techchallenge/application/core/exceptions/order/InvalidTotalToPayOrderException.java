package com.postech.entregavel1techchallenge.application.core.exceptions.order;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class InvalidTotalToPayOrderException extends BaseException {
    public InvalidTotalToPayOrderException(String message) {
        super(message);
    }
}
