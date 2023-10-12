package com.postech.entregavel1techchallenge.adapters.out.repository.mapper;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.ProductEntity;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    @Mapping(source = "images", target = "images", qualifiedByName = "setImages")
    ProductEntity toProductEntity(Product product);

    @Mapping(source = "images", target = "images", qualifiedByName = "setImagesList")
    Product toProduct(ProductEntity productEntity);

    @Named("setImages")
    default String setImages(List<String> images) {
        if(Objects.isNull(images))
            return null;
        return String.join(",", images);
    }

    @Named("setImagesList")
    default List<String> setImagesList(String images) {
        if(Objects.isNull(images))
            return Collections.emptyList();
        return Arrays.asList(images.split(","));
    }
}
