package com.postech.entregavel1techchallenge.adapters.in.controller.order.response;

import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class OrderItemResponse {

    private Integer quantity;

    private BigDecimal amount;

    //private Product product;
}
