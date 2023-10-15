package com.postech.entregavel1techchallenge.adapters.out.product;

import com.postech.entregavel1techchallenge.adapters.out.repository.ProductRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.ProductEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductsByCategoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetProductsByCategoryAdapter implements GetProductsByCategoryOutputPort {

    private final ProductRepository productRepository;

    private final ProductEntityMapper entityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Product> get(String category) {
        return productRepository.findByCategory(category).stream()
                .map(entityMapper::toProduct)
                .toList();
    }
}
