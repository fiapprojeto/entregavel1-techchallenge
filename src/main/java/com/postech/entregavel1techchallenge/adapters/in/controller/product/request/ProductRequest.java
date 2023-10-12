package com.postech.entregavel1techchallenge.adapters.in.controller.product.request;

import com.postech.entregavel1techchallenge.application.core.domain.product.enums.CategoryEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private List<String> images;
    private BigDecimal amount;
    private CategoryEnum category;
}
