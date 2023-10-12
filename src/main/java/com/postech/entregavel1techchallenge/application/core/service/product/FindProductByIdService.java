package com.postech.entregavel1techchallenge.application.core.service.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.core.exceptions.product.ProductNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.product.FindProductByIdInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductByIdService implements FindProductByIdInputPort {

    private final GetProductByIdOutputPort getProductByIdOutputPort;

    @Override
    public Product get(String id) {
        return getProductByIdOutputPort.get(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado para o id informado."));
    }
}
