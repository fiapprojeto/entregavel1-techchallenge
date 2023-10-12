package com.postech.entregavel1techchallenge.application.core.service.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.in.product.CreateProductInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.SaveProductOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductInputPort {

    private final SaveProductOutputPort saveProductOutputPort;

    @Override
    public Product save(Product product) {
        return saveProductOutputPort.save(product);
    }
}
