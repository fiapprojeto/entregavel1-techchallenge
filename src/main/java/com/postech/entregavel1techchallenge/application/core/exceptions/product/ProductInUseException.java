package com.postech.entregavel1techchallenge.application.core.exceptions.product;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class ProductInUseException extends BaseException {
    public ProductInUseException(String message) {
        super(message);
    }
}
