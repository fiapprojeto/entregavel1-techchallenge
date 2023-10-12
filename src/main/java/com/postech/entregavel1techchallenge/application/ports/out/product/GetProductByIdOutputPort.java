package com.postech.entregavel1techchallenge.application.ports.out.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;

import java.util.Optional;

public interface GetProductByIdOutputPort {

    Optional<Product> get(String id);
}
