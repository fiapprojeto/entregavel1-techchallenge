package com.postech.entregavel1techchallenge.adapters.out.product;

import com.postech.entregavel1techchallenge.adapters.out.repository.ProductRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.ProductEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindProductByIdAdapter implements GetProductByIdOutputPort {

    private final ProductRepository productRepository;

    private final ProductEntityMapper entityMapper;
    @Override
    @Transactional(readOnly = true)
    public Optional<Product> get(String id) {
        return productRepository.findById(id)
                .map(entityMapper::toProduct);
    }
}
