package com.postech.entregavel1techchallenge.application.core.service.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.core.exceptions.product.ProductNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.product.UpdateProductInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductByIdOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.SaveProductOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductInputPort {


    private final SaveProductOutputPort saveProductOutputPort;

    private final GetProductByIdOutputPort getProductByIdOutputPort;

    @Override
    public Product update(String id, Product product) {
        var productSaved = getProductByIdOutputPort.get(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado para atualizar o registro."));

        productSaved.updateFields(product);

        return saveProductOutputPort.save(productSaved);
    }
}
