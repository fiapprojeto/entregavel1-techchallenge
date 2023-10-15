package com.postech.entregavel1techchallenge.adapters.in.controller.order.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderRequest {

    private String customerId;
    private List<OrderItemRequest> items;

}
