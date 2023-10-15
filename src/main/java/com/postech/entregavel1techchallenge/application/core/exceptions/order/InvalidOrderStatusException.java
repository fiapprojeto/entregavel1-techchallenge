package com.postech.entregavel1techchallenge.application.core.exceptions.order;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class InvalidOrderStatusException extends BaseException {
    public InvalidOrderStatusException(String message) {
        super(message);
    }
}
