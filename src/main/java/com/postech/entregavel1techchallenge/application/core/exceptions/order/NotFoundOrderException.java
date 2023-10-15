package com.postech.entregavel1techchallenge.application.core.exceptions.order;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class NotFoundOrderException extends BaseException {
    public NotFoundOrderException(String message) {
        super(message);
    }
}
