package com.postech.entregavel1techchallenge.application.core.service.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.in.product.GetProductsByCategoryInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductsByCategoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductsByCategoryService implements GetProductsByCategoryInputPort {

    private final GetProductsByCategoryOutputPort getProductsByCategoryOutputPort;

    @Override
    public List<Product> get(String category) {
        return getProductsByCategoryOutputPort.get(category);
    }
}
