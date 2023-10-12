package com.postech.entregavel1techchallenge.adapters.in.controller.product.mapper;

import com.postech.entregavel1techchallenge.adapters.in.controller.product.request.ProductRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.response.ProductResponse;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestResponseMapper {


    Product toProduct(ProductRequest productRequest);


    ProductResponse toProductResponse(Product product);


}
