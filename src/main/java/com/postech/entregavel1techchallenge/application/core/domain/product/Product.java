package com.postech.entregavel1techchallenge.application.core.domain.product;

import com.postech.entregavel1techchallenge.application.core.domain.product.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;

    public void updateFields(Product product) {
        this.setImages(product.getImages());
        this.setName(product.getName());
        this.setAmount(product.getAmount());
        this.setDescription(product.getDescription());
        this.setCategory(product.getCategory());
    }
}
