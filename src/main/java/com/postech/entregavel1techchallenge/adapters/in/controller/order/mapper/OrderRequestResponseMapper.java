package com.postech.entregavel1techchallenge.adapters.in.controller.order.mapper;

import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.OrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.response.OrderResponse;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRequestResponseMapper {

    Order toOrder(OrderRequest orderRequest);

    OrderResponse toOrderResponse(Order order);
}
