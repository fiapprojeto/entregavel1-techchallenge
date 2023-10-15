package com.postech.entregavel1techchallenge.application.ports.in.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.Order;

public interface CreateOrderInputPort {

    Order create(Order order);
}
