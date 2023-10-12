package com.postech.entregavel1techchallenge.adapters.out.product;

import com.postech.entregavel1techchallenge.adapters.out.repository.ProductRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.ProductEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.out.product.SaveProductOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SaveProductAdapter implements SaveProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductEntityMapper entityMapper;

    @Override
    @Transactional
    public Product save(Product product) {
        var productEntity = entityMapper.toProductEntity(product);
        productRepository.save(productEntity);
        return entityMapper.toProduct(productEntity);
    }
}
