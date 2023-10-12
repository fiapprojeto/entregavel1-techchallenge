package com.postech.entregavel1techchallenge.application.ports.in.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;

public interface FindProductByIdInputPort {

    Product get(String id);
}
