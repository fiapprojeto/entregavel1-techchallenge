package com.postech.entregavel1techchallenge.application.core.exceptions.product;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
