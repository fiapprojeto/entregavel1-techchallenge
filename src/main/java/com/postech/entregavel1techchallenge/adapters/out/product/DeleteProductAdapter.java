package com.postech.entregavel1techchallenge.adapters.out.product;


import com.postech.entregavel1techchallenge.adapters.out.repository.ProductRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.ProductEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.out.product.DeleteProductOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DeleteProductAdapter implements DeleteProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductEntityMapper entityMapper;

    @Override
    @Transactional
    public void delete(Product product) {
        productRepository.delete(entityMapper.toProductEntity(product));
    }
}
