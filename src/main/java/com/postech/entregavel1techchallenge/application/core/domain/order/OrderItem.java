package com.postech.entregavel1techchallenge.application.core.domain.order;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItem {

    private Integer quantity;

    private BigDecimal amount;

    private Product product;

    public BigDecimal calculate() {
        this.amount = product.getAmount();
        return product.getAmount().multiply(BigDecimal.valueOf(quantity));
    }
}
