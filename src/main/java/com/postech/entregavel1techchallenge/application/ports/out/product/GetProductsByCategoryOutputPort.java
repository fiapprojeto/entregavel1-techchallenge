package com.postech.entregavel1techchallenge.application.ports.out.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;

import java.util.List;

public interface GetProductsByCategoryOutputPort {
    List<Product> get(String category);
}
