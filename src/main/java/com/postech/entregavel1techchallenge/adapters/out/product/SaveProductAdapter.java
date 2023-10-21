package com.postech.entregavel1techchallenge.adapters.out.product;

import com.postech.entregavel1techchallenge.adapters.out.repository.ProductRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.ProductEntity;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import com.postech.entregavel1techchallenge.application.ports.out.product.SaveProductOutputPort;
import com.postech.entregavel1techchallenge.config.mapper.ModelMapperCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SaveProductAdapter implements SaveProductOutputPort {

    private final ProductRepository productRepository;

    private final ModelMapperCustom mapper;

    @Override
    @Transactional
    public Product save(Product product) {
        var productEntity = mapper.map(product, ProductEntity.class);
        productEntity.setImages(setImages(product.getImages()));
        productRepository.save(productEntity);
        var productSaved = mapper.map(productEntity, Product.class);

        productSaved.setImages(setImagesList(productEntity.getImages()));

        return productSaved;
    }


    private String setImages(List<String> images) {
        if(Objects.isNull(images))
            return null;
        return String.join(",", images);
    }

    private List<String> setImagesList(String images) {
        if(Objects.isNull(images))
            return Collections.emptyList();
        return Arrays.asList(images.split(","));
    }
}
