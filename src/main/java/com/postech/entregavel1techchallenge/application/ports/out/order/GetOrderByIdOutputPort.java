package com.postech.entregavel1techchallenge.application.ports.out.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.Order;

import java.util.Optional;

public interface GetOrderByIdOutputPort {

    Optional<Order> get(String orderId);
}
