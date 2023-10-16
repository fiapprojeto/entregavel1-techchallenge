package com.postech.entregavel1techchallenge.application.core.domain.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String name;
    private String description;
    private List<String> images;
    private BigDecimal amount;
    private CategoryEnum category;
}
