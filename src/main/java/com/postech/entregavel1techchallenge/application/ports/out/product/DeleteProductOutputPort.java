package com.postech.entregavel1techchallenge.application.ports.out.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;

public interface DeleteProductOutputPort {

    void delete(Product product);
}
