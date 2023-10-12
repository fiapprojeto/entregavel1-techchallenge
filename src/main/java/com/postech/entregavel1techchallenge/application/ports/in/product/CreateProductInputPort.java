package com.postech.entregavel1techchallenge.application.ports.in.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;

public interface CreateProductInputPort {

    Product save(Product product);
}
