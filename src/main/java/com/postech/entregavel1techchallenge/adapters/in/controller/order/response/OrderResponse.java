package com.postech.entregavel1techchallenge.adapters.in.controller.order.response;

import com.postech.entregavel1techchallenge.application.core.domain.order.OrderItem;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderProgressEnum;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderResponse {

    private String id;

    private String customerId;

    private OrderStatusEnum status;

    private OrderProgressEnum progress;

    private List<OrderItemResponse> items;

    private BigDecimal total;
}
