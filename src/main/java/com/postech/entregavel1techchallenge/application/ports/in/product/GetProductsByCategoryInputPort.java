package com.postech.entregavel1techchallenge.application.ports.in.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;

import java.util.List;

public interface GetProductsByCategoryInputPort {
    List<Product> get(String category);
}
