package com.postech.entregavel1techchallenge.adapters.in.controller.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String customerId;
    private List<OrderItemRequest> items;

}
