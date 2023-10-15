package com.postech.entregavel1techchallenge.adapters.in.controller.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {

    private Integer quantity;
    private Product product;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Product {
        private String id;
    }
}
