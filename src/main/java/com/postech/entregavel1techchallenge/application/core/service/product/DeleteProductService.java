package com.postech.entregavel1techchallenge.application.core.service.product;


import com.postech.entregavel1techchallenge.application.core.exceptions.product.ProductInUseException;
import com.postech.entregavel1techchallenge.application.core.exceptions.product.ProductNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.product.DeleteProductInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.ExistsOrderItemByProductIdOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.DeleteProductOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductInputPort {

    private final DeleteProductOutputPort deleteProductOutputPort;

    private final GetProductByIdOutputPort getProductByIdOutputPort;

    private final ExistsOrderItemByProductIdOutputPort existsOrderItemByProductIdOutputPort;

    @Override
    public void delete(String id) {
        var product = getProductByIdOutputPort.get(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado para apagar o registro."));

        if(existsOrderItemByProductIdOutputPort.exists(product.getId()))
            throw new ProductInUseException("Não é posssível apagar um produto que está em uso.");

        deleteProductOutputPort.delete(product);
    }
}
